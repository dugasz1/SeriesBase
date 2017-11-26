package com.github.dugasz1.seriesbase.core.model;

import java.util.Collection;
import java.util.Date;

public class Episode {
    //This id is only unique in the season
    private int id;
    private String title;
    private int duration;
    private Date airTime;
    private Collection<Actor> actors;

    public Episode(int id, String title, int duration, Date airTime, Collection<Actor> actors) {
        setId(id);
        setTitle(title);
        setDuration(duration);
        setAirTime(airTime);
        setActors(actors);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getAirTime() {
        return airTime;
    }

    public void setAirTime(Date airTime) {
        this.airTime = airTime;
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }
}
