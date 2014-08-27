package com.lounge.stat.dto;

import com.lounge.stat.model.MatchEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by jsarafajr on 27.08.14.
 */
public class Match {
    private int id;
    private String team1Name;
    private String team2Name;
    private int team1Score;
    private int team2Score;
    private String date;

    public Match(MatchEntity en) {
        id = en.getId();
        team1Name = en.getTeam1().getName();
        team2Name = en.getTeam2().getName();
        team1Score = en.getScore1();
        team2Score = en.getScore2();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        date = sdf.format(en.getDate());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
