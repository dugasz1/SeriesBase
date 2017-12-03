package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeasonNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;

import java.util.Collection;

public interface SeasonService {
    Collection<Season> listSeasonsBySeriesId(int seriesId) throws SeriesNotExistException, StorageErrorException;

    Season getSeason(int seriesId, int seasonId) throws SeriesNotExistException, StorageErrorException, SeasonNotExistException;

    void recordSeason(int seriesId, Season season);
}
