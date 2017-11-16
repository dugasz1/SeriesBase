package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Actor> listAllActor(){
        return actorService.listActors();
    }

    @RequestMapping(value = "/{actorName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Actor getActorByName(@PathVariable(value = "actorName") String actorName) {
        return actorService.searchActorByName(actorName);
    }
}
