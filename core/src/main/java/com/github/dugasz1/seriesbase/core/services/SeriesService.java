package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesExistException;

import java.util.Collection;

public interface SeriesService {
    Collection<Series> listSeries();

    Series getSeriesById(int id);

    /**
     * Seacrh by name (Not case sensitive)
     * @param title
     * @return if not found then empty list
     */
    Collection<Series> searchSeriesByName(String title);

    /**
     * Record a series
     * @param series
     * @throws SeriesExistException if there is a series with exactly the same name
     */
    void recordSeries(Series series) throws SeriesExistException;
}
