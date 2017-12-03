package com.github.dugasz1.seriesbase.service.dao;

import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;

import java.util.Collection;

public interface SeasonDAO {
    Collection<Season> listSeasonBySeriesId(int seriesId) throws SeriesIdNotExistException, PersistException;

    void addSeasonsToSeriesById(int seriesId) throws SeriesIdNotExistException;
}
