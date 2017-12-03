package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorNotExistException;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
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
    private ActorDAO actorXmlDAO;
    private Document document;
    private Element root;
    private DateFormat airTimeFormat;

    public EpisodeXmlDAO(XmlDb xmlDb, ActorDAO actorXmlDAO) {
        this.xmlDb = xmlDb;
        this.actorXmlDAO = actorXmlDAO;
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

            Collection<Actor> actors = getEpisodeActors((Element) currEpisode);

            Episode episode = new Episode(id, title, duration, airTime, actors);
            result.add(episode);
        }
        return result;
    }

    private Collection<Actor> getEpisodeActors(Element episode){
        NodeList actorsNode = episode.getElementsByTagName("ActorRefKey");

        Collection<Actor> actors= new ArrayList<Actor>();
        for (int i = 0; i < actorsNode.getLength() ; i++) {
            Node actorNode = actorsNode.item(i);
            NamedNodeMap attributes = actorNode.getAttributes();
            int actorId = Integer.valueOf(attributes.getNamedItem("refKey").getNodeValue());
            Actor actor = null;
            try {
                actor = actorXmlDAO.readActorById(actorId);
                actors.add(actor);
            } catch (ActorNotExistException e) {
                e.printStackTrace(); //Log the corrupted database
            }
        }

        return actors;
    }
}
