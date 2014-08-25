package com.lounge.stat.dto;

import com.lounge.stat.model.PredictionEntity;
import com.lounge.stat.model.TeamEntity;

import java.sql.Timestamp;

/**
 * Created by jsarafajr on 25.08.14.
 */
public class Prediction {
    private int id;
    private String team1Name;
    private String team2Name;
    private int percent1;
    private int percent2;
    private int team1Wincoef;
    private int team2Wincoef;
    private int team1Latestcoef;
    private int team2Latestcoef;
    private int team1matches;
    private int team2matches;
    private int team1wins;
    private int team2wins;
    private String team1image;
    private String team2image;
    private Timestamp date;

    public Prediction(PredictionEntity en) {
        id = en.getId();

        team1Name = en.getTeam1().getName();
        team2Name = en.getTeam2().getName();

        percent1 = en.getPercent1();
        percent2 = en.getPercent2();

        team1Wincoef = en.getTeam1Wincoef();
        team2Wincoef = en.getTeam2Wincoef();

        team1Latestcoef = en.getTeam1Latestcoef();
        team2Latestcoef = en.getTeam2Latestcoef();

        team1matches = en.getTeam1().getMatches();
        team2matches = en.getTeam2().getMatches();

        team1wins = en.getTeam1().getWins();
        team2wins = en.getTeam2().getWins();

        team1image = en.getTeam1().getImage();
        team2image = en.getTeam2().getImage();

        date = en.getDate();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercent1() {
        return percent1;
    }

    public void setPercent1(int percent1) {
        this.percent1 = percent1;
    }

    public int getPercent2() {
        return percent2;
    }

    public void setPercent2(int percent2) {
        this.percent2 = percent2;
    }

    public int getTeam1Wincoef() {
        return team1Wincoef;
    }

    public void setTeam1Wincoef(int team1Wincoef) {
        this.team1Wincoef = team1Wincoef;
    }

    public int getTeam2Wincoef() {
        return team2Wincoef;
    }

    public void setTeam2Wincoef(int team2Wincoef) {
        this.team2Wincoef = team2Wincoef;
    }

    public int getTeam1Latestcoef() {
        return team1Latestcoef;
    }

    public void setTeam1Latestcoef(int team1Latestcoef) {
        this.team1Latestcoef = team1Latestcoef;
    }

    public int getTeam2Latestcoef() {
        return team2Latestcoef;
    }

    public void setTeam2Latestcoef(int team2Latestcoef) {
        this.team2Latestcoef = team2Latestcoef;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public int getTeam1matches() {
        return team1matches;
    }

    public void setTeam1matches(int team1matches) {
        this.team1matches = team1matches;
    }

    public int getTeam2matches() {
        return team2matches;
    }

    public void setTeam2matches(int team2matches) {
        this.team2matches = team2matches;
    }

    public int getTeam1wins() {
        return team1wins;
    }

    public void setTeam1wins(int team1wins) {
        this.team1wins = team1wins;
    }

    public int getTeam2wins() {
        return team2wins;
    }

    public void setTeam2wins(int team2wins) {
        this.team2wins = team2wins;
    }

    public String getTeam1image() {
        return team1image;
    }

    public void setTeam1image(String team1image) {
        this.team1image = team1image;
    }

    public String getTeam2image() {
        return team2image;
    }

    public void setTeam2image(String team2image) {
        this.team2image = team2image;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
