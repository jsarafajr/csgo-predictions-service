package com.lounge.stat.service;

import com.lounge.stat.dto.Match;
import com.lounge.stat.dto.Prediction;
import com.lounge.stat.dto.Team;
import com.lounge.stat.model.MatchEntity;
import com.lounge.stat.model.PredictionEntity;
import com.lounge.stat.model.TeamEntity;
import com.lounge.stat.repository.MatchDao;
import com.lounge.stat.repository.PredictionDao;
import com.lounge.stat.repository.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsarafajr on 27.08.14.
 */
@Service
public class MatchService {
    @Autowired
    private PredictionDao predictionDao;
    @Autowired
    private MatchDao matchDao;

    public List<Match> getMatches(int predictionId) {
        PredictionEntity prediction = predictionDao.get(predictionId);
        TeamEntity team1 = prediction.getTeam1();
        TeamEntity team2 = prediction.getTeam2();

        List<MatchEntity> matches = matchDao.getTeamsVersusMatches(team1, team2);
        List<Match> res = new ArrayList<>(matches.size());

        for (MatchEntity m : matches) {
            res.add(new Match(m));
        }

        return res;
    }
}
