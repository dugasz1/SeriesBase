package com.github.dugasz1.seriesbase.service.dao;

import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeasonIdNotExistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;

import java.util.Collection;

public interface EpisodeDAO {
    Collection<Episode> listEpisodes(int seriesId, int seasonId) throws SeriesIdNotExistException, SeasonIdNotExistException, PersistException;
}
