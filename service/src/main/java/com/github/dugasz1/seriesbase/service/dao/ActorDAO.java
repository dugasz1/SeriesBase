package com.github.dugasz1.seriesbase.service.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

public interface ActorDAO {
    void createActor(Actor actor) throws IOException, TransformerException;

    Collection<Actor> readActors() throws ParseException;
    Actor readActorByName(String name);


}
