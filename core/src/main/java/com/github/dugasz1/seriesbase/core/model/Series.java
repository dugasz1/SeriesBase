package com.github.dugasz1.seriesbase.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dugasz1.seriesbase.core.model.exceptions.InvalidRatingException;

import java.util.Collection;

public class Series {
    private int id;
    private String title;
    private Collection<Season> seasons;
    private int rating;
    private int duration;

    @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
    public Series(@JsonProperty("id") int id, @JsonProperty("title") String title, @JsonProperty("seasons") Collection<Season> seasons, @JsonProperty("rating") int rating, @JsonProperty("duration") int duration) throws InvalidRatingException {
        setId(id);
        setTitle(title);
        setSeasons(seasons);
        setRating(rating);
        setDuration(duration);
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

    public Collection<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Collection<Season> seasons) {
        this.seasons = seasons;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws InvalidRatingException {
        if(rating < 0 || rating > 10)
            throw new InvalidRatingException("Rating must be between [0,10]. " + rating + " is out of that range");
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
