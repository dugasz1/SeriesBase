package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Gender;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Actor> listAllActor(){
        try {
            return actorService.listActors();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/get/{actorName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Actor> getActorByName(@PathVariable(value = "actorName") String actorName) throws ParseException {
        return actorService.searchActorByName(actorName);
    }

    @RequestMapping(value = "/add/{actorName}", method = RequestMethod.GET)
    @ResponseBody
    public Actor addActor(@PathVariable(value = "actorName") String actorName) {
        Actor actor = new Actor(10, actorName, Gender.FEMALE);
        actorService.recordActor(actor);
        return actor;
    }
}
