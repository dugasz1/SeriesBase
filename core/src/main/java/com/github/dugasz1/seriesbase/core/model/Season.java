package com.github.dugasz1.seriesbase.core.model;

import java.util.Collection;

public class Season {
    //This id is only unique in the series
    private int id;
    private Collection<Episode> episodes;

    public Season(int id, Series parentSeries, Collection<Episode> episodes) {
        setId(id);

        setEpisodes(episodes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Collection<Episode> episodes) {
        this.episodes = episodes;
    }
}
