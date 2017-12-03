package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.service.dao.EpisodeDAO;
import com.github.dugasz1.seriesbase.service.dao.SeasonDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeasonIdNotExistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.Collection;

public class SeasonXmlDAO implements SeasonDAO {
    private XmlDb xmlDb;
    private EpisodeDAO episodeDAO;
    private Document document;
    private Element root;

    public SeasonXmlDAO(XmlDb xmlDb, EpisodeDAO episodeDAO) {
        this.xmlDb = xmlDb;
        this.episodeDAO = episodeDAO;
        document = xmlDb.getDocument();
        root = document.getDocumentElement();

    }

    protected static Element findSeriesElement(Element root, int seriesId){
        NodeList allSeries = root.getElementsByTagName("Series");
        for (int i = 0; i < allSeries.getLength(); i++) {
            Node currSeries = allSeries.item(i);
            NamedNodeMap attributes = currSeries.getAttributes();
            int id = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            if(seriesId == id) {
                Element seriesElement = (Element) currSeries;
                return seriesElement;
            }
        }
        return null;
    }

    @Override
    public Collection<Season> listSeasonBySeriesId(int seriesId) throws SeriesIdNotExistException, PersistException {
        Element seriesElement = findSeriesElement(root, seriesId);
        if(seriesElement == null)
            throw new SeriesIdNotExistException("Series with id of " + seriesId + " not exist.");


        NodeList seasons = seriesElement.getElementsByTagName("Season");
        Collection<Season> result = new ArrayList<>(seasons.getLength());
        for (int i = 0; i < seasons.getLength(); i++) {
            Node currSeason = seasons.item(i);
            NamedNodeMap attributes = currSeason.getAttributes();
            int seasonId = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            Collection<Episode> episodes = null;
            try {
                episodes = episodeDAO.listEpisodes(seriesId, seasonId);
            } catch (SeasonIdNotExistException e) {
                throw new PersistException("Something went really wrong", e);
            }

            Season season = new Season(seasonId, episodes);
            result.add(season);
        }
        return result;
    }

    @Override
    public void addSeasonsToSeriesById(int seriesId) throws SeriesIdNotExistException {

    }
}
