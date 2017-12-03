package com.github.dugasz1.seriesbase.service.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorNotExistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

public interface ActorDAO {
    void createActor(Actor actor) throws PersistException;

    Collection<Actor> readActors();

    Actor readActorById(int id) throws ActorNotExistException;
}
