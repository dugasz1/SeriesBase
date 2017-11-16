package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;

import java.util.Collection;

public interface EpisodeService {
    Collection<Episode> listEpisodeBySeason(Season season);

    void recordEpisode(Episode episode);

    /**
     * Check is two episode have overlap in their airtime.
     * @param e1 Any episode of any series
     * @param e2 Any episode of any series
     * @return
     */
    boolean isEpisodesConcurrent(Episode e1, Episode e2);

}
