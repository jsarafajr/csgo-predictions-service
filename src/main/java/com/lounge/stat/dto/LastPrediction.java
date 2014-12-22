package com.lounge.stat.dto;

import com.lounge.stat.model.LastCustomPredictionEntity;

import java.util.Date;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
>>>>>>> origin/master

/**
 * Created by jsarafajr on 03.09.14.
 */
public class LastPrediction {
    private int id;
    private String team1;
    private String team2;
    private int sec;
    private int min;
    private int hour;
    private int day;

    public LastPrediction(LastCustomPredictionEntity entity) {
        id = entity.getId();
        team1 = entity.getTeam1().getName();
        team2 = entity.getTeam2().getName();

        long diffInMillis = new Date().getTime() - entity.getDate().getTime();

        sec = (int) (diffInMillis / 1000) % 60;
        min = (int) (diffInMillis / (1000 * 60)) % 60;
        hour = (int) (diffInMillis / (1000 * 60 * 60)) % 24;
        day = (int) (diffInMillis / (1000 * 60 * 60 * 24)) % 30;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
