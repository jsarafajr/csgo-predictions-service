package com.lounge.stat.model;

import javax.persistence.*;

/**
 * Created by jsarafajr on 16.08.14.
 */
@Entity
@Table(name = "Statistic")
public class StatisticEntity {
    private int id;
    private TeamEntity team;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Integer dust2Played;

    @Basic
    @Column(name = "dust2_played")
    public Integer getDust2Played() {
        return dust2Played;
    }

    public void setDust2Played(Integer dust2Played) {
        this.dust2Played = dust2Played;
    }

    private Integer dust2Won;

    @Basic
    @Column(name = "dust2_won")
    public Integer getDust2Won() {
        return dust2Won;
    }

    public void setDust2Won(Integer dust2Won) {
        this.dust2Won = dust2Won;
    }

    private Integer infernoPlayed;

    @Basic
    @Column(name = "inferno_played")
    public Integer getInfernoPlayed() {
        return infernoPlayed;
    }

    public void setInfernoPlayed(Integer infernoPlayed) {
        this.infernoPlayed = infernoPlayed;
    }

    private Integer infernoWon;

    @Basic
    @Column(name = "inferno_won")
    public Integer getInfernoWon() {
        return infernoWon;
    }

    public void setInfernoWon(Integer infernoWon) {
        this.infernoWon = infernoWon;
    }

    private Integer miragePlayed;

    @Basic
    @Column(name = "mirage_played")
    public Integer getMiragePlayed() {
        return miragePlayed;
    }

    public void setMiragePlayed(Integer miragePlayed) {
        this.miragePlayed = miragePlayed;
    }

    private Integer mirageWon;

    @Basic
    @Column(name = "mirage_won")
    public Integer getMirageWon() {
        return mirageWon;
    }

    public void setMirageWon(Integer mirageWon) {
        this.mirageWon = mirageWon;
    }

    private Integer overpasPlayed;

    @Basic
    @Column(name = "overpas_played")
    public Integer getOverpasPlayed() {
        return overpasPlayed;
    }

    public void setOverpasPlayed(Integer overpasPlayed) {
        this.overpasPlayed = overpasPlayed;
    }

    private Integer overpasWon;

    @Basic
    @Column(name = "overpas_won")
    public Integer getOverpasWon() {
        return overpasWon;
    }

    public void setOverpasWon(Integer overpasWon) {
        this.overpasWon = overpasWon;
    }

    private Integer cbblePlayed;

    @Basic
    @Column(name = "cbble_played")
    public Integer getCbblePlayed() {
        return cbblePlayed;
    }

    public void setCbblePlayed(Integer cbblePlayed) {
        this.cbblePlayed = cbblePlayed;
    }

    private Integer cbbleWon;

    @Basic
    @Column(name = "cbble_won")
    public Integer getCbbleWon() {
        return cbbleWon;
    }

    public void setCbbleWon(Integer cbbleWon) {
        this.cbbleWon = cbbleWon;
    }

    private Integer nukePlayed;

    @Basic
    @Column(name = "nuke_played")
    public Integer getNukePlayed() {
        return nukePlayed;
    }

    public void setNukePlayed(Integer nukePlayed) {
        this.nukePlayed = nukePlayed;
    }

    private Integer nukeWon;

    @Basic
    @Column(name = "nuke_won")
    public Integer getNukeWon() {
        return nukeWon;
    }

    public void setNukeWon(Integer nukeWon) {
        this.nukeWon = nukeWon;
    }

    private Integer cachePlayed;

    @Basic
    @Column(name = "cache_played")
    public Integer getCachePlayed() {
        return cachePlayed;
    }

    public void setCachePlayed(Integer cachePlayed) {
        this.cachePlayed = cachePlayed;
    }

    private Integer cacheWon;

    @Basic
    @Column(name = "cache_won")
    public Integer getCacheWon() {
        return cacheWon;
    }

    public void setCacheWon(Integer cacheWon) {
        this.cacheWon = cacheWon;
    }

    private Integer trainPlayed;

    @Basic
    @Column(name = "train_played")
    public Integer getTrainPlayed() {
        return trainPlayed;
    }

    public void setTrainPlayed(Integer trainPlayed) {
        this.trainPlayed = trainPlayed;
    }

    private Integer trainWon;

    @Basic
    @Column(name = "train_won")
    public Integer getTrainWon() {
        return trainWon;
    }

    public void setTrainWon(Integer trainWon) {
        this.trainWon = trainWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticEntity statistic = (StatisticEntity) o;

        if (id != statistic.id) return false;
        if (cachePlayed != null ? !cachePlayed.equals(statistic.cachePlayed) : statistic.cachePlayed != null)
            return false;
        if (cacheWon != null ? !cacheWon.equals(statistic.cacheWon) : statistic.cacheWon != null) return false;
        if (cbblePlayed != null ? !cbblePlayed.equals(statistic.cbblePlayed) : statistic.cbblePlayed != null)
            return false;
        if (cbbleWon != null ? !cbbleWon.equals(statistic.cbbleWon) : statistic.cbbleWon != null) return false;
        if (dust2Played != null ? !dust2Played.equals(statistic.dust2Played) : statistic.dust2Played != null)
            return false;
        if (dust2Won != null ? !dust2Won.equals(statistic.dust2Won) : statistic.dust2Won != null) return false;
        if (infernoPlayed != null ? !infernoPlayed.equals(statistic.infernoPlayed) : statistic.infernoPlayed != null)
            return false;
        if (infernoWon != null ? !infernoWon.equals(statistic.infernoWon) : statistic.infernoWon != null) return false;
        if (miragePlayed != null ? !miragePlayed.equals(statistic.miragePlayed) : statistic.miragePlayed != null)
            return false;
        if (mirageWon != null ? !mirageWon.equals(statistic.mirageWon) : statistic.mirageWon != null) return false;
        if (nukePlayed != null ? !nukePlayed.equals(statistic.nukePlayed) : statistic.nukePlayed != null) return false;
        if (nukeWon != null ? !nukeWon.equals(statistic.nukeWon) : statistic.nukeWon != null) return false;
        if (overpasPlayed != null ? !overpasPlayed.equals(statistic.overpasPlayed) : statistic.overpasPlayed != null)
            return false;
        if (overpasWon != null ? !overpasWon.equals(statistic.overpasWon) : statistic.overpasWon != null) return false;
        if (trainPlayed != null ? !trainPlayed.equals(statistic.trainPlayed) : statistic.trainPlayed != null)
            return false;
        if (trainWon != null ? !trainWon.equals(statistic.trainWon) : statistic.trainWon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dust2Played != null ? dust2Played.hashCode() : 0);
        result = 31 * result + (dust2Won != null ? dust2Won.hashCode() : 0);
        result = 31 * result + (infernoPlayed != null ? infernoPlayed.hashCode() : 0);
        result = 31 * result + (infernoWon != null ? infernoWon.hashCode() : 0);
        result = 31 * result + (miragePlayed != null ? miragePlayed.hashCode() : 0);
        result = 31 * result + (mirageWon != null ? mirageWon.hashCode() : 0);
        result = 31 * result + (overpasPlayed != null ? overpasPlayed.hashCode() : 0);
        result = 31 * result + (overpasWon != null ? overpasWon.hashCode() : 0);
        result = 31 * result + (cbblePlayed != null ? cbblePlayed.hashCode() : 0);
        result = 31 * result + (cbbleWon != null ? cbbleWon.hashCode() : 0);
        result = 31 * result + (nukePlayed != null ? nukePlayed.hashCode() : 0);
        result = 31 * result + (nukeWon != null ? nukeWon.hashCode() : 0);
        result = 31 * result + (cachePlayed != null ? cachePlayed.hashCode() : 0);
        result = 31 * result + (cacheWon != null ? cacheWon.hashCode() : 0);
        result = 31 * result + (trainPlayed != null ? trainPlayed.hashCode() : 0);
        result = 31 * result + (trainWon != null ? trainWon.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Team", referencedColumnName = "id")
    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }
}
