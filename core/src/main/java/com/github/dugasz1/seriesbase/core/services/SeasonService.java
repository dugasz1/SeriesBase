package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.model.Series;

import java.util.Collection;

public interface SeasonService {
    Collection<Season> listSeasonsBySeries(Series series);

    void recordSeason(Season season);
}
