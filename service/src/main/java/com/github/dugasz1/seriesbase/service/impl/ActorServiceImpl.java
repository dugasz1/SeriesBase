package com.github.dugasz1.seriesbase.service.impl;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;

import java.util.Collection;

public class ActorServiceImpl implements ActorService {
    private ActorDAO actorDAO;

    public ActorServiceImpl(ActorDAO actorDAO){
        this.actorDAO = actorDAO;
    }

    public Collection<Actor> listActors() {
        return actorDAO.readActors();
    }

    public Actor searchActorByName(String name) {
        return actorDAO.readActorByName(name);
    }

    public void recordActor(Actor actor) {
        actorDAO.createActor(actor);
    }
}
