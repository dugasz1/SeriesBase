package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Gender;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.model.exceptions.InvalidRatingException;
import com.github.dugasz1.seriesbase.dao.exceptions.UnableToSaveException;
import com.github.dugasz1.seriesbase.service.dao.SeasonDAO;
import com.github.dugasz1.seriesbase.service.dao.SeriesDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.Collection;

public class SeriesXmlDAO implements SeriesDAO{
    private XmlDb xmlDb;
    private SeasonDAO seasonDAO;
    private Document document;
    private Element root;

    private Node seriesNode;

    public SeriesXmlDAO(XmlDb xmlDb, SeasonDAO seasonDAO) {
        this.xmlDb = xmlDb;
        this.seasonDAO = seasonDAO;

        document = xmlDb.getDocument();
        root = document.getDocumentElement();

        NodeList actors = root.getElementsByTagName("Serieses");
        seriesNode = actors.item(0);
    }

    @Override
    public Series createSeries(Series series) throws PersistException {
        Element newSeries = document.createElement("Series");
        series.setId(xmlDb.GetNewSeriesId());
        newSeries.setAttribute("id", String.valueOf(series.getId()));
        newSeries.setAttribute("duration", String.valueOf(series.getDuration()));
        newSeries.setAttribute("rating", String.valueOf(series.getRating()));
        newSeries.setAttribute("title", series.getTitle());

        seriesNode.appendChild(newSeries);

        try {
            xmlDb.Save();
        } catch (UnableToSaveException e) {
            throw new PersistException("Storage fail - Can not store new series", e);
        }

        return series;
    }

    @Override
    public Collection<Series> readSeries() throws PersistException {
        NodeList allSeries = root.getElementsByTagName("Series");
        Collection<Series> actors = new ArrayList<Series>(allSeries.getLength());

        int i;
        for (i = 0; i<allSeries.getLength(); i++){
            Node seriesNode = allSeries.item(i);
            NamedNodeMap attributes = seriesNode.getAttributes();
            int id = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            String title = attributes.getNamedItem("title").getNodeValue();
            int duration = Integer.valueOf(attributes.getNamedItem("duration").getNodeValue());
            int rating = Integer.valueOf(attributes.getNamedItem("rating").getNodeValue());

            try {
                Collection<Season> seasons = seasonDAO.listSeasonBySeriesId(id);
                Series series = new Series(id, title, seasons, rating, duration);
                actors.add(series);
            } catch (InvalidRatingException e) {
                e.printStackTrace(); //Log and skip it, then continue
            } catch (SeriesIdNotExistException e) {
                throw new PersistException("Something went really wrong", e);
            }
        }

        return actors;
    }

    @Override
    public Series readSeriesById(int id) throws SeriesIdNotExistException, PersistException {
        NodeList allSeries = root.getElementsByTagName("Series");
        Series theSeries = null;

        for (int i = 0; i < allSeries.getLength(); i++) {
            Node seriesNode = allSeries.item(i);
            NamedNodeMap attributes = seriesNode.getAttributes();
            int seriesId = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            if(seriesId != id) {
                continue;
            }
            String title = attributes.getNamedItem("title").getNodeValue();
            int duration = Integer.valueOf(attributes.getNamedItem("duration").getNodeValue());
            int rating = Integer.valueOf(attributes.getNamedItem("rating").getNodeValue());

            try {
                Collection<Season> seasons = seasonDAO.listSeasonBySeriesId(id);
                theSeries = new Series(id, title, seasons, rating, duration);
            } catch (InvalidRatingException e) {
                e.printStackTrace(); //Log and skip it, then continue
            } catch (SeriesIdNotExistException e) {
                throw new PersistException("Something went really wrong", e);
            }
        }
        if(theSeries == null){
            throw new SeriesIdNotExistException("Series not exist: " + id);
        }

        return theSeries;
    }
}
