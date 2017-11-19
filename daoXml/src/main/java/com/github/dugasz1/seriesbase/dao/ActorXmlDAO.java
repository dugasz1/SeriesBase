package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Gender;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ActorXmlDAO implements ActorDAO {
    private Actor actor;
    private Collection<Actor> actors;

    private XmlDb xmlDb;
    private Document document;
    private Element root;

    public ActorXmlDAO(XmlDb xmlDb) {
        this.xmlDb = xmlDb;
        document = xmlDb.getDocument();
        root = document.getDocumentElement();

        actor = new Actor(1, "Brad Pitt", new Date(2017-1-1), Gender.MALE);
        actors = new ArrayList<Actor>(1);
        actors.add(actor);
    }

    public void createActor(Actor actor) throws IOException, TransformerException {
        NodeList actors = root.getElementsByTagName("Actors");
        Node actorsNode = actors.item(0); //There must be one Actors element because of xsd

        Element newActor = document.createElement("Actor");
        newActor.setAttribute("id", String.valueOf(123));
        newActor.setAttribute("name", actor.getName());
        newActor.setAttribute("gender", actor.getGender().toString());

        actorsNode.appendChild(newActor);

        xmlDb.Save();
    }

    public Collection<Actor> readActors() {
        return actors;
    }

    public Actor readActorByName(String name) {
        return actor;
    }
}
