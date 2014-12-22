package com.lounge.stat.service;

import com.lounge.stat.dto.LastPrediction;
import com.lounge.stat.model.LastCustomPredictionEntity;
import com.lounge.stat.model.PredictionEntity;
import com.lounge.stat.repository.LastPredDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jsarafajr on 03.09.14.
 */
@Service
public class LastPredService {
    @Autowired
    private LastPredDao lastPredDao;

    private final int LATES_PREDICTIONS_COUNT = 7;

    public void addPrediction(PredictionEntity prediction) {
        LastCustomPredictionEntity lastPrediction = new LastCustomPredictionEntity();
        lastPrediction.setTeam1(prediction.getTeam1());
        lastPrediction.setTeam2(prediction.getTeam2());
        lastPrediction.setDate(new Timestamp(new Date().getTime()));

        trimToSize();

        lastPredDao.save(lastPrediction);
    }

    public List<LastPrediction> getAll() {
        List<LastCustomPredictionEntity> predEntities = lastPredDao.getAll();
        List<LastPrediction> result = new ArrayList<>(predEntities.size());

        for (LastCustomPredictionEntity entity : predEntities) {
            result.add(new LastPrediction(entity));
        }

        return result;
    }

    private void trimToSize() {
        List<LastCustomPredictionEntity> lastPredictions = lastPredDao.getAll();
        if (lastPredictions.size() < LATES_PREDICTIONS_COUNT) return;
        LastCustomPredictionEntity entityToRemove = lastPredictions.get(lastPredictions.size() - 1);
        lastPredDao.delete(entityToRemove);
    }
}
