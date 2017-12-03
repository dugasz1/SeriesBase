package com.github.dugasz1.seriesbase.controller;

import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.SeriesService;
import com.github.dugasz1.seriesbase.core.services.exceptions.ActorExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/api/series")
public class SeriesController {
    private SeriesService seriesService;

    public SeriesController (SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @RequestMapping(value = "/get/{seriesTitle}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Series> searchSeries(@PathVariable("seriesTitle") String seriesTitle) throws StorageErrorException {
        return seriesService.searchSeriesByTitle(seriesTitle);
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Series> listAllSeries() throws StorageErrorException {
        return seriesService.listSeries();
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Series addSeries(@RequestBody Series series) throws StorageErrorException, SeriesExistException {
        seriesService.recordSeries(series);

        return series;
    }

    @ExceptionHandler(value = {StorageErrorException.class, SeriesExistException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String addActorExceptionHandler(Exception e){
        return e.getMessage();
    }
}
