package com.github.dugasz1.seriesbase.service.impl;

import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.services.EpisodeService;
import com.github.dugasz1.seriesbase.core.services.exceptions.EpisodeNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeasonNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import com.github.dugasz1.seriesbase.service.dao.EpisodeDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeasonIdNotExistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;

import java.util.Collection;

public class EpisodeServiceImpl implements EpisodeService {
    private EpisodeDAO episodeDAO;

    public EpisodeServiceImpl(EpisodeDAO episodeDAO) {
        this.episodeDAO = episodeDAO;
    }

    public Collection<Episode> listEpisodeBySeason(int seriesId, int seasonId) throws SeasonNotExistException, SeriesNotExistException, StorageErrorException {
        try {
            return episodeDAO.listEpisodes(seriesId, seasonId);
        } catch (SeriesIdNotExistException e) {
            throw new SeriesNotExistException(e);
        } catch (SeasonIdNotExistException e) {
            throw new SeasonNotExistException(e);
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }
    }

    public void recordEpisode(int seriesId, int seasonId, Episode episode) {

    }

    public Episode getEpisode(int seriesId, int seasonId, int episodeId) throws SeriesNotExistException, SeasonNotExistException, StorageErrorException, EpisodeNotExistException {
        Collection<Episode> episodes = null;
        try {
            episodes = episodeDAO.listEpisodes(seriesId, seasonId);
        } catch (SeriesIdNotExistException e) {
            throw new SeriesNotExistException(e);
        } catch (SeasonIdNotExistException e) {
            throw new SeasonNotExistException(e);
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }

        for (Episode episode:episodes) {
            if(episode.getId() == episodeId){
                return episode;
            }
        }

        throw new EpisodeNotExistException("Episode "+ episodeId +" not exist in season "+ seasonId + ", series " + seriesId);
    }
}
