package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Gender;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ActorXmlDAO implements ActorDAO {
    private Actor actor;
    private Collection<Actor> actors;

    public ActorXmlDAO() {
        actor = new Actor(1, "Brad Pitt", new Date(2017-1-1), Gender.MALE);
        actors = new ArrayList<Actor>(1);
        actors.add(actor);
    }

    public void createActor(Actor actor) {

    }

    public Collection<Actor> readActors() {
        return actors;
    }

    public Actor readActorByName(String name) {
        return actor;
    }
}
