package com.github.dugasz1.seriesbase.service.impl;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;

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

    public Collection<Actor> listActors() throws ParseException {
        return actorDAO.readActors();
    }

    public Collection<Actor> searchActorByName(String name) throws ParseException {
        Collection<Actor> actors = actorDAO.readActors();
        Collection<Actor> result = new ArrayList<Actor>();
        for (Actor actor : actors) {
            if(actor.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(actor);
            }
        }
        return result;
    }

    public void recordActor(Actor actor) {
        try {
            actorDAO.createActor(actor);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
