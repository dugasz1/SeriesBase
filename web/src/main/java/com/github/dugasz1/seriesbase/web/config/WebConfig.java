package com.github.dugasz1.seriesbase.web.config;

import com.github.dugasz1.seriesbase.controller.ActorController;
import com.github.dugasz1.seriesbase.controller.ActorViewController;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.dao.ActorXmlDAO;
import com.github.dugasz1.seriesbase.dao.XmlDb;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import com.github.dugasz1.seriesbase.service.impl.ActorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig {

    @Bean(value = "xmlDb")
    public XmlDb initXmlDb() {
        return new XmlDb(System.getProperty("db_file_path"));
    }

    @Bean(value = "actorDAO")
    public ActorDAO initActorDAO(){
        return new ActorXmlDAO(initXmlDb());
    }

    @Bean(value = "actorService")
    public ActorService initActorService() {
        return new ActorServiceImpl(initActorDAO());
    }

    @Bean(value = "actorController")
    public ActorController initActorController() {
        return new ActorController(initActorService());
    }

    @Bean
    public ActorViewController initActorViewController(){
        return new ActorViewController();
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setViewClass(JstlView.class);
        result.setPrefix("/WEB-INF/views/");
        result.setSuffix(".jsp");
        return result;
    }
}
