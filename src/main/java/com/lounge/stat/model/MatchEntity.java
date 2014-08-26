package com.lounge.stat.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jsarafajr on 16.08.14.
 */
@Entity
@Table(name = "Mtch")
public class MatchEntity {
    private int id;
    private Integer score1;
    private Integer score2;
    private Timestamp date;
    private TeamEntity team1;
    private TeamEntity team2;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Score1")
    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    @Basic
    @Column(name = "Score2")
    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    @Basic
    @Column(name = "Date")
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

        MatchEntity match = (MatchEntity) o;

        if (id != match.id) return false;
        if (date != null ? !date.equals(match.date) : match.date != null) return false;
        if (score1 != null ? !score1.equals(match.score1) : match.score1 != null) return false;
        if (score2 != null ? !score2.equals(match.score2) : match.score2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (score1 != null ? score1.hashCode() : 0);
        result = 31 * result + (score2 != null ? score2.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", team1=" + team1.getName() +
                ", score1=" + score1 +
                ", team2=" + team2.getName() +
                ", score2=" + score2 +
                ", date=" + date +
                '}';
    }
}
