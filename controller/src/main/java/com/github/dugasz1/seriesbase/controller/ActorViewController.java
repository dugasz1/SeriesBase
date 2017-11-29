package com.github.dugasz1.seriesbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
public class ActorViewController {
    @RequestMapping("model")
    public ModelAndView model() throws Exception{
        ModelAndView modelAndView = new ModelAndView("teszt");
        modelAndView.addObject("msg", "This is my msg");
        return modelAndView;
    }
}
