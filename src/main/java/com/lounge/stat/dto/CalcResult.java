package com.lounge.stat.dto;

/**
 * Created by jsarafajr on 25.08.14.
 */
public class CalcResult {
    private int team1Total;
    private int team2Total;
    private int team1WinCoef;
    private int team2WinCoef;
    private int team1LatestWins;
    private int team2LatestWins;
    private int versusCount;
    private int vsTeam1Wins;
    private int vsTeam2Wins;

    public int getVersusCount() {
        return versusCount;
    }

    public void setVersusCount(int versusCount) {
        this.versusCount = versusCount;
    }

    public int getVsTeam1Wins() {
        return vsTeam1Wins;
    }

    public void setVsTeam1Wins(int vsTeam1Wins) {
        this.vsTeam1Wins = vsTeam1Wins;
    }

    public int getVsTeam2Wins() {
        return vsTeam2Wins;
    }

    public void setVsTeam2Wins(int vsTeam2Wins) {
        this.vsTeam2Wins = vsTeam2Wins;
    }

    public int getTeam1Total() {
        return team1Total;
    }

    public void setTeam1Total(int team1Total) {
        this.team1Total = team1Total;
    }

    public int getTeam2Total() {
        return team2Total;
    }

    public void setTeam2Total(int team2Total) {
        this.team2Total = team2Total;
    }

    public int getTeam1WinCoef() {
        return team1WinCoef;
    }

    public void setTeam1WinCoef(int team1WinCoef) {
        this.team1WinCoef = team1WinCoef;
    }

    public int getTeam2WinCoef() {
        return team2WinCoef;
    }

    public void setTeam2WinCoef(int team2WinCoef) {
        this.team2WinCoef = team2WinCoef;
    }

    public int getTeam1LatestWins() {
        return team1LatestWins;
    }

    public void setTeam1LatestWins(int team1LatestWins) {
        this.team1LatestWins = team1LatestWins;
    }

    public int getTeam2LatestWins() {
        return team2LatestWins;
    }

    public void setTeam2LatestWins(int team2LatestWins) {
        this.team2LatestWins = team2LatestWins;
    }
}
