package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.services.exceptions.EpisodeNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeasonNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;

import java.util.Collection;

public interface EpisodeService {
    Collection<Episode> listEpisodeBySeason(int seriesId, int seasonId) throws SeasonNotExistException, SeriesNotExistException, StorageErrorException;

    void recordEpisode(int seriesId, int seasonId, Episode episode);

    Episode getEpisode(int seriesId, int seasonId, int episodeId) throws SeriesNotExistException, SeasonNotExistException, StorageErrorException, EpisodeNotExistException;

}
