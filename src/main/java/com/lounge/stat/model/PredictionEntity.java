package com.lounge.stat.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jsarafajr on 24.08.14.
 */
@Entity
@Table(name = "Prediction")
public class PredictionEntity {
    private int id;
    private Integer percent1;
    private Integer percent2;
    private Integer team1Wincoef;
    private Integer team2Wincoef;
    private Integer team1Latestcoef;
    private Integer team2Latestcoef;
    private TeamEntity team1;
    private TeamEntity team2;
    private Timestamp date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Percent1")
    public Integer getPercent1() {
        return percent1;
    }

    public void setPercent1(Integer percent1) {
        this.percent1 = percent1;
    }

    @Basic
    @Column(name = "Percent2")
    public Integer getPercent2() {
        return percent2;
    }

    public void setPercent2(Integer percent2) {
        this.percent2 = percent2;
    }

    @Basic
    @Column(name = "team1wincoef")
    public Integer getTeam1Wincoef() {
        return team1Wincoef;
    }

    public void setTeam1Wincoef(Integer team1Wincoef) {
        this.team1Wincoef = team1Wincoef;
    }

    @Basic
    @Column(name = "team2wincoef")
    public Integer getTeam2Wincoef() {
        return team2Wincoef;
    }

    public void setTeam2Wincoef(Integer team2Wincoef) {
        this.team2Wincoef = team2Wincoef;
    }

    @Basic
    @Column(name = "team1latestcoef")
    public Integer getTeam1Latestcoef() {
        return team1Latestcoef;
    }

    public void setTeam1Latestcoef(Integer team1Latestcoef) {
        this.team1Latestcoef = team1Latestcoef;
    }

    @Basic
    @Column(name = "team2latestcoef")
    public Integer getTeam2Latestcoef() {
        return team2Latestcoef;
    }

    public void setTeam2Latestcoef(Integer team2Latestcoef) {
        this.team2Latestcoef = team2Latestcoef;
    }

    @ManyToOne
    @JoinColumn(name = "Team1", referencedColumnName = "id")
    public TeamEntity getTeam1() {
        return team1;
    }

    public void setTeam1(TeamEntity team1) {
        this.team1 = team1;
    }

    @ManyToOne
    @JoinColumn(name = "Team2", referencedColumnName = "id")
    public TeamEntity getTeam2() {
        return team2;
    }

    public void setTeam2(TeamEntity team2) {
        this.team2 = team2;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PredictionEntity that = (PredictionEntity) o;

        if (id != that.id) return false;
        if (percent1 != null ? !percent1.equals(that.percent1) : that.percent1 != null) return false;
        if (percent2 != null ? !percent2.equals(that.percent2) : that.percent2 != null) return false;
        if (team1Latestcoef != null ? !team1Latestcoef.equals(that.team1Latestcoef) : that.team1Latestcoef != null)
            return false;
        if (team1Wincoef != null ? !team1Wincoef.equals(that.team1Wincoef) : that.team1Wincoef != null) return false;
        if (team2Latestcoef != null ? !team2Latestcoef.equals(that.team2Latestcoef) : that.team2Latestcoef != null)
            return false;
        if (team2Wincoef != null ? !team2Wincoef.equals(that.team2Wincoef) : that.team2Wincoef != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (percent1 != null ? percent1.hashCode() : 0);
        result = 31 * result + (percent2 != null ? percent2.hashCode() : 0);
        result = 31 * result + (team1Wincoef != null ? team1Wincoef.hashCode() : 0);
        result = 31 * result + (team2Wincoef != null ? team2Wincoef.hashCode() : 0);
        result = 31 * result + (team1Latestcoef != null ? team1Latestcoef.hashCode() : 0);
        result = 31 * result + (team2Latestcoef != null ? team2Latestcoef.hashCode() : 0);
        return result;
    }
}
