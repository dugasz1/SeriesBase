package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Actor;
import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.SeriesService;
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

    public SeriesViewController(SeriesService seriesService) {
        this.seriesService = seriesService;
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
}
