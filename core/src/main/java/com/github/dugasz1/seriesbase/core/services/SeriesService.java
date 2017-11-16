package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Series;

import java.util.Collection;

public interface SeriesService {
    Collection<Series> listSeries();

    Series searchSeriesByName(String title);

    void recordSeries(Series series);
}
