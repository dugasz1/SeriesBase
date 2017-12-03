package com.github.dugasz1.seriesbase.service.dao;

import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;

import java.util.Collection;

public interface SeriesDAO {
    Series createSeries(Series series) throws PersistException;

    Collection<Series> readSeries() throws PersistException;

    Series readSeriesById(int id) throws SeriesIdNotExistException, PersistException;
}
