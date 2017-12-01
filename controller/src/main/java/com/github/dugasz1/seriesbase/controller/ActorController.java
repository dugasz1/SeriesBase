package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Actor addActor(@RequestBody Actor actor) throws StorageErrorException, ActorExistException {
        //Actor actor = new Actor(10, actorName, Gender.FEMALE);
        System.out.println(actor.toString());
        actorService.recordActor(actor);
        return actor;
    }

    @ExceptionHandler(value = {StorageErrorException.class, ActorExistException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String addActorExceptionHandler(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(value = {org.springframework.http.converter.HttpMessageConversionException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String httpMessageConversionHandler() {
        return "Can not convert the given value.";
    }
}
