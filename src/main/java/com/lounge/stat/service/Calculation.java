package com.lounge.stat.service;

import com.lounge.stat.dto.CalcResult;
import com.lounge.stat.repository.MatchDao;
import com.lounge.stat.model.MatchEntity;
import com.lounge.stat.model.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jsarafajr on 16.08.14.
 */

@Service
public class Calculation {
    @Autowired
    private MatchDao matchDao;

    public CalcResult getResult(TeamEntity team1, TeamEntity team2) {
        double team1WinLoseCoeff = getWinLoseCoeff(team1);
        double team2WinLoseCoeff = getWinLoseCoeff(team2);
        double team1LastMatchesCoeff = getLastMatchesCoef(team1, 10);
        double team2LastMatchesCoeff = getLastMatchesCoef(team2, 10);
        double team1vsTeam2LastMatchesCoeff = getLastVersusMatchesCoef(team1, team2, 5);
        double team2vsTeam1LastMatchesCoeff = 1f - team1vsTeam2LastMatchesCoeff;

        double team1Total = team1WinLoseCoeff * 0.3 + team1LastMatchesCoeff * 0.3 + team1vsTeam2LastMatchesCoeff * 0.4;
        double team2Total = team2WinLoseCoeff * 0.3 + team2LastMatchesCoeff * 0.3 + team2vsTeam1LastMatchesCoeff * 0.4;

        CalcResult res = new CalcResult();

        res.setTeam1WinCoef((int) (team1WinLoseCoeff * 100));
        res.setTeam2WinCoef((int) (team2WinLoseCoeff * 100));

        res.setTeam1LatestWins(getLastWinsCount(team1, 10));
        res.setTeam2LatestWins(getLastWinsCount(team2, 10));

        double k = 1f / (team1Total + team2Total);

        res.setTeam1Total((int) (100 * team1Total * k));
        res.setTeam2Total(100 - res.getTeam1Total());

        return res;
    }

    public double getWinLoseCoeff(TeamEntity team) {
        return (double) team.getWins() / (double) team.getMatches();
    }

    public double getLastMatchesCoef(TeamEntity team, int count) {
        List<MatchEntity> lastMatches = matchDao.getTeamMatches(team, count);
        int winsCount = getWinsCount(lastMatches, team);

        if (lastMatches.size() == 0) return 0;
        return (double) winsCount / lastMatches.size();
    }

    public double getLastVersusMatchesCoef(TeamEntity team1, TeamEntity team2, int count) {
        List<MatchEntity> lastMatches = matchDao.getTeamsVersusMatches(team1, team2, count);
        int team1WinsCount = getWinsCount(lastMatches, team1);

        if (lastMatches.size() == 0) return 0.5;
        return (double) team1WinsCount / lastMatches.size();
    }

    private int getLastWinsCount(TeamEntity team, int count) {
        List<MatchEntity> lastMatches = matchDao.getTeamMatches(team, count);
        return getWinsCount(lastMatches, team);
    }

    private int getWinsCount(List<MatchEntity> matches, TeamEntity team) {
        String teamName = team.getName();
        int winCount = 0;

        for (int i = 0; i < matches.size(); i++) {
            MatchEntity m = matches.get(i);
            // some shit below
            if (m.getScore1().equals(m.getScore2())) {
                matches.remove(i);
                i--;
            }
            else {
                if (m.getTeam1().getName().equals(teamName) && m.getScore1() > m.getScore2())
                    winCount++;
                if (m.getTeam2().getName().equals(teamName) && m.getScore2() > m.getScore1()) {
                    winCount++;
                }
            }
        }

        return winCount;
    }
}
