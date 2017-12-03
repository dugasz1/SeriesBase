package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;

import java.util.Collection;

public interface SeriesService {
    Collection<Series> listSeries() throws StorageErrorException;

    Series getSeriesById(int id) throws SeriesNotExistException, StorageErrorException;

    /**
     * Seacrh by name (Not case sensitive)
     * @param title
     * @return if not found then empty list
     */
    Collection<Series> searchSeriesByTitle(String title) throws StorageErrorException;

    /**
     * Record a series
     * @param series
     * @throws SeriesExistException if there is a series with exactly the same name
     */
    void recordSeries(Series series) throws SeriesExistException;
}
