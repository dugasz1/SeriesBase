package com.github.dugasz1.seriesbase.web.config;

import com.github.dugasz1.seriesbase.controller.ActorController;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.dao.ActorXmlDAO;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import com.github.dugasz1.seriesbase.service.impl.ActorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean(value = "actorDAO")
    public ActorDAO initActorDAO(){
        return new ActorXmlDAO();
    }

    @Bean(value = "actorService")
    public ActorService initActorService() {
        return new ActorServiceImpl(initActorDAO());
    }

    @Bean(value = "actorController")
    public ActorController initActorController() {
        return new ActorController(initActorService());
    }
}