package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RequestMapping("/")
public class ActorViewController {
    private ActorService actorService;

    public ActorViewController (ActorService actorService){
        this.actorService = actorService;
    }

    @RequestMapping("actor/{actorName}")
    public ModelAndView actorView(@PathVariable("actorName")String actorName) throws Exception{
        Collection<Actor> actors = actorService.searchActorByName(actorName);
        if(actors.size() == 0) {

            return new ModelAndView("redirect:/");
        }
        Actor actor = actors.iterator().next();

        ModelAndView modelAndView = new ModelAndView("actor");
        modelAndView.addObject("actor", actor);
        return modelAndView;
    }
}
