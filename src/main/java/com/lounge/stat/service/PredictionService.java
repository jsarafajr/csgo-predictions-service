package com.lounge.stat.service;

import com.lounge.stat.dto.CalcResult;
import com.lounge.stat.dto.Prediction;
import com.lounge.stat.model.PredictionEntity;
import com.lounge.stat.model.TeamEntity;
import com.lounge.stat.repository.PredictionDao;
import com.lounge.stat.repository.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by jsarafajr on 24.08.14.
 */
@Service
public class PredictionService {
    @Autowired
    private LastPredService lastPredService;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private PredictionDao predictionDao;
    @Autowired
    private Calculation calculation;

    public void addNewPrediction(String name1, String name2,
                                 int day, int mounth, int year) {

        TeamEntity team1 = teamDao.get(name1);
        TeamEntity team2 = teamDao.get(name2);

        CalcResult calcResult = calculation.getResult(team1, team2);

        PredictionEntity prediction = new PredictionEntity();

        prediction.setDate(new Timestamp(new GregorianCalendar(year, mounth, day).getTimeInMillis()));
        prediction.setTeam1(team1);
        prediction.setTeam2(team2);
        prediction.setPercent1(calcResult.getTeam1Total());
        prediction.setPercent2(calcResult.getTeam2Total());
        prediction.setTeam1Wincoef(calcResult.getTeam1WinCoef());
        prediction.setTeam2Wincoef(calcResult.getTeam2WinCoef());
        prediction.setTeam1Latestcoef(calcResult.getTeam1LatestWins());
        prediction.setTeam2Latestcoef(calcResult.getTeam2LatestWins());
        prediction.setVersusCount(calcResult.getVersusCount());
        prediction.setVsTeam1Wins(calcResult.getVsTeam1Wins());
        prediction.setVsTeam2Wins(calcResult.getVsTeam2Wins());

        predictionDao.save(prediction);
    }

    public Prediction getSinglePrediction(String teamName1, String teamName2) {
        TeamEntity team1 = teamDao.get(teamName1);
        TeamEntity team2 = teamDao.get(teamName2);

        CalcResult calcResult = calculation.getResult(team1, team2);

        PredictionEntity prediction = new PredictionEntity();

        prediction.setTeam1(team1);
        prediction.setTeam2(team2);
        prediction.setPercent1(calcResult.getTeam1Total());
        prediction.setPercent2(calcResult.getTeam2Total());
        prediction.setTeam1Wincoef(calcResult.getTeam1WinCoef());
        prediction.setTeam2Wincoef(calcResult.getTeam2WinCoef());
        prediction.setTeam1Latestcoef(calcResult.getTeam1LatestWins());
        prediction.setTeam2Latestcoef(calcResult.getTeam2LatestWins());
        prediction.setVersusCount(calcResult.getVersusCount());
        prediction.setVsTeam1Wins(calcResult.getVsTeam1Wins());
        prediction.setVsTeam2Wins(calcResult.getVsTeam2Wins());

        lastPredService.addPrediction(prediction);

        return new Prediction(prediction);
    }

    public ArrayList<Prediction> getAllSorted() {
        List<PredictionEntity> entities = predictionDao.getAllSorted(); // todo add order
        ArrayList<Prediction> predictions = new ArrayList<>(entities.size());

        for (PredictionEntity en : entities) {
            predictions.add(new Prediction(en));
        }

        return predictions;
    }
}
