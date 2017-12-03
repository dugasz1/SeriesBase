package com.github.dugasz1.seriesbase.web.config;

import com.github.dugasz1.seriesbase.controller.ActorController;
import com.github.dugasz1.seriesbase.controller.ActorViewController;
import com.github.dugasz1.seriesbase.controller.SeriesController;
import com.github.dugasz1.seriesbase.controller.SeriesViewController;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.services.ActorService;
import com.github.dugasz1.seriesbase.core.services.EpisodeService;
import com.github.dugasz1.seriesbase.core.services.SeasonService;
import com.github.dugasz1.seriesbase.core.services.SeriesService;
import com.github.dugasz1.seriesbase.dao.*;
import com.github.dugasz1.seriesbase.service.dao.ActorDAO;
import com.github.dugasz1.seriesbase.service.dao.EpisodeDAO;
import com.github.dugasz1.seriesbase.service.dao.SeasonDAO;
import com.github.dugasz1.seriesbase.service.dao.SeriesDAO;
import com.github.dugasz1.seriesbase.service.impl.ActorServiceImpl;
import com.github.dugasz1.seriesbase.service.impl.EpisodeServiceImpl;
import com.github.dugasz1.seriesbase.service.impl.SeasonServiceImpl;
import com.github.dugasz1.seriesbase.service.impl.SeriesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig {
    private XmlDb xmlDb = null;

    @Bean(value = "xmlDb")
    public XmlDb initXmlDb() {
        if(xmlDb == null) {
            xmlDb = new XmlDb(System.getProperty("db_file_path"));
        }
        return xmlDb;
    }

    // -------- DAOs --------
    @Bean(value = "actorDAO")
    public ActorDAO initActorDAO(){
        return new ActorXmlDAO(initXmlDb());
    }

    @Bean
    public SeriesDAO initSeriesDAO(){
        return new SeriesXmlDAO(initXmlDb(), initSeasonDAO());
    }

    @Bean
    public SeasonDAO initSeasonDAO() {
        return new SeasonXmlDAO(initXmlDb(), initEpisodeDAO());
    }

    @Bean
    public EpisodeDAO initEpisodeDAO() {
        return new EpisodeXmlDAO(initXmlDb(), initActorDAO());
    }

    // -------- Services --------
    @Bean(value = "actorService")
    public ActorService initActorService() {
        return new ActorServiceImpl(initActorDAO());
    }

    @Bean
    public SeriesService initSeriesService() {
        return new SeriesServiceImpl(initSeriesDAO());
    }

    @Bean
    public SeasonService initSeasonService(){
        return new SeasonServiceImpl(initSeasonDAO());
    }

    @Bean
    public EpisodeService initEpisodeService(){
        return new EpisodeServiceImpl(initEpisodeDAO());
    }

    // -------- Controllers --------
    @Bean(value = "actorController")
    public ActorController initActorController() {
        return new ActorController(initActorService());
    }

    @Bean
    public SeriesController initSeriesController(){
        return new SeriesController(initSeriesService());
    }

    @Bean
    public ActorViewController initActorViewController(){
        return new ActorViewController(initActorService());
    }

    @Bean
    public SeriesViewController initSeriesViewContorller() {
        return new SeriesViewController(initSeriesService(), initSeasonService(), initEpisodeService());
    }



    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setPrefix("/WEB-INF/views/");
        result.setSuffix(".jsp");
        return result;
    }
}
