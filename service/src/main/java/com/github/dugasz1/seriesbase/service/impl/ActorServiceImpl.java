package com.github.dugasz1.seriesbase.service.impl;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

public class ActorServiceImpl implements ActorService {
    private ActorDAO actorDAO;

    public ActorServiceImpl(ActorDAO actorDAO){
        this.actorDAO = actorDAO;
    }

    public Collection<Actor> listActors() {
        return actorDAO.readActors();
    }

    public Collection<Actor> searchActorByName(String name) {
        Collection<Actor> actors = actorDAO.readActors();
        Collection<Actor> result = new ArrayList<Actor>();
        for (Actor actor : actors) {
            if(actor.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(actor);
            }
        }
        return result;
    }

    public void recordActor(Actor actor) throws StorageErrorException, ActorExistException {
        Collection<Actor> actors = listActors();
        for (Actor currActor: actors) {
            if(currActor.getName().equals(actor.getName())){
                throw new ActorExistException(actor.getName() + " is already exist.");
            }
        }

        try {
            actorDAO.createActor(actor);
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }
    }
}
