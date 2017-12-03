package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.service.dao.EpisodeDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeasonIdNotExistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;
import org.w3c.dom.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class EpisodeXmlDAO implements EpisodeDAO {
    private XmlDb xmlDb;
    private Document document;
    private Element root;
    private DateFormat airTimeFormat;

    public EpisodeXmlDAO(XmlDb xmlDb) {
        this.xmlDb = xmlDb;
        document = xmlDb.getDocument();
        root = document.getDocumentElement();

        airTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    }

    protected static Element findSeasonElement(Element series, int seasonId){
        NodeList seasons = series.getElementsByTagName("Season");

        for (int i = 0; i < seasons.getLength() ; i++) {
            Node currSeason = seasons.item(i);
            NamedNodeMap attributes = currSeason.getAttributes();
            int id = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            if(seasonId == id) {
                Element seasonElement = (Element) currSeason;
                return seasonElement;
            }
        }
        return null;
    }

    @Override
    public Collection<Episode> listEpisodes(int seriesId, int seasonId) throws SeriesIdNotExistException, SeasonIdNotExistException, PersistException {
        Element seriesElement = SeasonXmlDAO.findSeriesElement(root, seriesId);
        if(seriesElement == null)
            throw new SeriesIdNotExistException("Series with id of " + seriesId + " not exist.");
        Element seasonElement = findSeasonElement(seriesElement, seasonId);
        if(seasonElement == null)
            throw new SeasonIdNotExistException("Season with id of " + seriesId + " not exist.");

        NodeList episodeNodes = seasonElement.getElementsByTagName("Episode");
        Collection<Episode> result = new ArrayList<Episode>(episodeNodes.getLength());
        for (int i = 0; i < episodeNodes.getLength(); i++) {
            Node currEpisode = episodeNodes.item(i);
            NamedNodeMap attributes = currEpisode.getAttributes();
            Date airTime = null;
            try {
                airTime = airTimeFormat.parse(attributes.getNamedItem("airTime").getNodeValue());
            } catch (ParseException e) {
                throw new PersistException("Can not parse up date: " + attributes.getNamedItem("airTime").getNodeValue(), e);
            }

            int duration = Integer.valueOf(attributes.getNamedItem("duration").getNodeValue());
            int id = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            String title = attributes.getNamedItem("title").getNodeValue();
            Episode episode = new Episode(id, title, duration, airTime, new ArrayList<Actor>());
            result.add(episode);
        }
        return result;
    }
}
