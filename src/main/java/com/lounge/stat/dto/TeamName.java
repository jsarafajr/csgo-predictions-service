package com.lounge.stat.dto;

/**
 * Created by jsarafajr on 23.08.14.
 */
public class TeamName {
    private int id;
    private String name;

    public TeamName(int id, String name) {
        this.id = id;
        this.name = name;
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
}
