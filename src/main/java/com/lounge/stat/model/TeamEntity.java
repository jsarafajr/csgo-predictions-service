package com.lounge.stat.model;

import javax.persistence.*;

/**
 * Created by jsarafajr on 16.08.14.
 */
@Entity
@Table(name = "Team")
public class TeamEntity {
    private int id;
    private String name;
    private int matches;
    private int wins;
    private String image;

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
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Matches")
    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public void incrementMathces() {
        matches++;
    }

    @Basic
    @Column(name = "Wins")
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void incrementWins() {
        wins++;
    }

    @Basic
    @Column(name = "Image")
    public String getImage() {
        return image;
    }

    public void setImage(String name) {
        this.image = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEntity team = (TeamEntity) o;

        if (id != team.id) return false;
        if (matches != team.matches) return false;
        if (wins != team.wins) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + matches;
        result = 31 * result + wins;
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matches=" + matches +
                ", wins=" + wins +
                '}';
    }
}
