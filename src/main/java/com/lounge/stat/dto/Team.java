package com.lounge.stat.dto;

/**
 * Created by jsarafajr on 25.08.14.
 */
public class Team {
    private int id;
    private String name;
    private int matches;
    private int wins;
    private String image;

    public Team(int id, String name, int matches, int wins, String image) {
        this.id = id;
        this.name = name;
        this.matches = matches;
        this.wins = wins;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
