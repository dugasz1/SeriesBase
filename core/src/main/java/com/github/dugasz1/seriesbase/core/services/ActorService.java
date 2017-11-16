package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Actor;

import java.util.Collection;

public interface ActorService {
    Collection<Actor> listActors();

    /**
     * Search actor
     * @param name Full name or part of him/her name. Not case sensitive.
     * @return
     */
    Actor searchActorByName(String name);

    void recordActor(Actor actor);
}
