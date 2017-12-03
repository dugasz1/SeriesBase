package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Gender;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorNotExistException;
import com.github.dugasz1.seriesbase.dao.exceptions.UnableToSaveException;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.Collection;

public class ActorXmlDAO implements ActorDAO {
    private XmlDb xmlDb;
    private Document document;
    private Element root;

    private Node actorsNode;

    public ActorXmlDAO(XmlDb xmlDb) {
        this.xmlDb = xmlDb;
        document = xmlDb.getDocument();
        root = document.getDocumentElement();

        NodeList actors = root.getElementsByTagName("Actors");
        actorsNode = actors.item(0);

    }

    public void createActor(Actor actor) throws PersistException {
        Element newActor = document.createElement("Actor");
        actor.setId(xmlDb.GetNewActorId());
        newActor.setAttribute("id", String.valueOf(actor.getId()));
        newActor.setAttribute("name", actor.getName());
        newActor.setAttribute("gender", actor.getGender().toString());

        actorsNode.appendChild(newActor);

        try {
            xmlDb.Save();
        } catch (UnableToSaveException e) {
            throw new PersistException("Storage fail - Can not store new actor", e);
        }
    }

    public Collection<Actor> readActors() {
        NodeList actorsNode = root.getElementsByTagName("Actor");
        Collection<Actor> actors = new ArrayList<Actor>(actorsNode.getLength());

        int i;
        for (i = 0; i<actorsNode.getLength(); i++){
            Node actorNode = actorsNode.item(i);
            NamedNodeMap attributes = actorNode.getAttributes();
            String id = attributes.getNamedItem("id").getNodeValue();
            String name = attributes.getNamedItem("name").getNodeValue();
            String gender = attributes.getNamedItem("gender").getNodeValue();

            Actor actor = new Actor(Integer.parseInt(id), name, Gender.valueOf(gender));
            actors.add(actor);
        }

        return actors;
    }

    public Actor readActorById(int id) throws ActorNotExistException {
        Collection<Actor> actors = readActors();

        for (Actor actor : actors) {
            if(actor.getId() == id){
                return actor;
            }
        }

        throw new ActorNotExistException("Actor with id " + id + " not exists.");
    }
}
