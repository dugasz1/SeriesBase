package com.github.dugasz1.seriesbase.service.impl;

import com.github.dugasz1.seriesbase.core.model.Season;
import com.github.dugasz1.seriesbase.core.model.Series;
import com.github.dugasz1.seriesbase.core.services.SeasonService;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeasonNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.SeriesNotExistException;
import com.github.dugasz1.seriesbase.core.services.exceptions.StorageErrorException;
import com.github.dugasz1.seriesbase.service.dao.SeasonDAO;
import com.github.dugasz1.seriesbase.service.dao.exceptions.PersistException;
import com.github.dugasz1.seriesbase.service.dao.exceptions.SeriesIdNotExistException;

import java.util.ArrayList;
import java.util.Collection;

public class SeasonServiceImpl implements SeasonService {
    private SeasonDAO seasonDAO;

    public SeasonServiceImpl(SeasonDAO seasonDAO) {
        this.seasonDAO = seasonDAO;
    }

    public Collection<Season> listSeasonsBySeriesId(int seriesId) throws SeriesNotExistException, StorageErrorException {
        try {
            return seasonDAO.listSeasonBySeriesId(seriesId);
        } catch (SeriesIdNotExistException e) {
            throw new SeriesNotExistException(e);
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }
    }

    public Season getSeason(int seriesId, int seasonId) throws SeriesNotExistException, StorageErrorException, SeasonNotExistException {
        Collection<Season> seasons = new ArrayList<Season>();
        try {
            seasons = seasonDAO.listSeasonBySeriesId(seriesId);
        } catch (SeriesIdNotExistException e) {
            throw new SeriesNotExistException(e);
        } catch (PersistException e) {
            throw new StorageErrorException(e);
        }

        for (Season season:seasons) {
            if(season.getId() == seasonId){
                return season;
            }
        }

        throw new SeasonNotExistException("There is no season "+ seasonId + " in the " + seriesId +". series.");
    }

    public void recordSeason(int seriesId, Season season) {

    }
}
