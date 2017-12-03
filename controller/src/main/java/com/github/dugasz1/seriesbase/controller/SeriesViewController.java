package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Episode;
import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.EpisodeService;
import com.github.dugasz1.seriesbase.core.services.SeasonService;
import com.github.dugasz1.seriesbase.core.services.SeriesService;
import com.github.dugasz1.seriesbase.core.services.exceptions.EpisodeNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeasonNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RequestMapping("/")
public class SeriesViewController {
    private SeriesService seriesService;
    private SeasonService seasonService;
    private EpisodeService episodeService;

    public SeriesViewController(SeriesService seriesService, SeasonService seasonService, EpisodeService episodeService) {
        this.seriesService = seriesService;
        this.seasonService = seasonService;
        this.episodeService = episodeService;
    }

    @RequestMapping("series/{seriesId}")
    @ResponseBody
    public ModelAndView seriesView(@PathVariable("seriesId") int seriesId) throws StorageErrorException {
        Series series;
        try {
            series = seriesService.getSeriesById(seriesId);
        } catch (SeriesNotExistException e) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("series");
        modelAndView.addObject("series", series);
        return modelAndView;
    }

    @RequestMapping("series/{seriesId}/{seasonId}")
    @ResponseBody
    public ModelAndView seasonView(@PathVariable("seriesId") int seriesId, @PathVariable("seasonId") int seasonId) throws StorageErrorException {
        Season season;
        Series series;
        try {
            series = seriesService.getSeriesById(seriesId);
            season = seasonService.getSeason(seriesId, seasonId);
        } catch (SeriesNotExistException e) {
            return new ModelAndView("redirect:/");
        } catch (SeasonNotExistException e) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("season");
        modelAndView.addObject("series", series);
        modelAndView.addObject("season", season);
        return modelAndView;
    }

    @RequestMapping("series/{seriesId}/{seasonId}/{episodeId}")
    @ResponseBody
    public ModelAndView episodeView(@PathVariable("seriesId") int seriesId, @PathVariable("seasonId") int seasonId, @PathVariable("episodeId") int episodeId) throws StorageErrorException {
        Season season;
        Series series;
        Episode episode;
        try {
            series = seriesService.getSeriesById(seriesId);
            season = seasonService.getSeason(seriesId, seasonId);
            episode = episodeService.getEpisode(seriesId, seasonId, episodeId);
        } catch (SeriesNotExistException e) {
            return new ModelAndView("redirect:/");
        } catch (SeasonNotExistException e) {
            return new ModelAndView("redirect:/");
        } catch (EpisodeNotExistException e) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("episode");
        modelAndView.addObject("series", series);
        modelAndView.addObject("season", season);
        modelAndView.addObject("episode", episode);
        return modelAndView;
    }
}
