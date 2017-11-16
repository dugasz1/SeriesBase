package com.github.dugasz1.seriesbase.service.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;

import java.util.Collection;

public interface ActorDAO {
    void createActor(Actor actor);

    Collection<Actor> readActors();
    Actor readActorByName(String name);


}
