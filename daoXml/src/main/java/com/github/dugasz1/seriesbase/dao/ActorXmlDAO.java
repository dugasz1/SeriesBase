package com.github.dugasz1.seriesbase.dao;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Gender;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import org.w3c.dom.*;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

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

    public void createActor(Actor actor) throws IOException, TransformerException {
        Element newActor = document.createElement("Actor");
        newActor.setAttribute("id", String.valueOf(123));
        newActor.setAttribute("name", actor.getName());
        newActor.setAttribute("gender", actor.getGender().toString());

        actorsNode.appendChild(newActor);

        xmlDb.Save();
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

    public Actor readActorByName(String name) {
        return null;
    }
}
