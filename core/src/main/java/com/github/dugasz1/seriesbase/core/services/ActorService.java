package com.github.dugasz1.seriesbase.core.services;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;

import java.text.ParseException;
import java.util.Collection;

public interface ActorService {
    Collection<Actor> listActors() throws ParseException;

    /**
     * Search actor
     * @param name Full name or part of him/her name. Not case sensitive.
     * @return
     */
    Collection<Actor> searchActorByName(String name) throws ParseException;

    void recordActor(Actor actor) throws ActorExistException, StorageErrorException;
}
