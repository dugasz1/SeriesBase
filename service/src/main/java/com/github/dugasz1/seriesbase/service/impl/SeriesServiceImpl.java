package com.github.dugasz1.seriesbase.service.impl;

import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.SeriesService;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import com.github.dugasz1.seriesbase.service.dao.SeriesDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;

import java.util.ArrayList;
import java.util.Collection;

public class SeriesServiceImpl implements SeriesService {
    private SeriesDAO seriesDAO;

    public SeriesServiceImpl(SeriesDAO seriesDAO) {
        this.seriesDAO = seriesDAO;
    }

    public Collection<Series> listSeries() throws StorageErrorException {
        try {
            return seriesDAO.readSeries();
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }
    }

    public Series getSeriesById(int id) throws SeriesNotExistException, StorageErrorException {
        try {
            return seriesDAO.readSeriesById(id);
        } catch (SeriesIdNotExistException e) {
            throw new SeriesNotExistException(e);
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }
    }

    public Collection<Series> searchSeriesByTitle(String title) throws StorageErrorException {
        Collection<Series> series;
        try {
             series = listSeries();
        } catch (StorageErrorException e) {
            throw new StorageErrorException(e);
        }

        Collection<Series> result = new ArrayList<Series>();
        for (Series currSeries: series) {
            if(currSeries.getTitle().toLowerCase().contains(title.toLowerCase())){
                result.add(currSeries);
            }
        }

        return result;
    }

    public void recordSeries(Series series) throws SeriesExistException {

    }
}
