package com.github.dugasz1.seriesbase.core.model;

import java.util.Collection;

public class Season {
    private int id;
    private int seasonId;
    private Collection<Episode> episodes;

    public Season(int id, int seasonId, Collection<Episode> episodes) {
        setId(id);
        setSeasonId(seasonId);
        setEpisodes(episodes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public Collection<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Collection<Episode> episodes) {
        this.episodes = episodes;
    }
}
