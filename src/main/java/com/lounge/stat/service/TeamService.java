package com.lounge.stat.service;

import com.lounge.stat.dto.Team;
import com.lounge.stat.dto.TeamName;
import com.lounge.stat.model.TeamEntity;
import com.lounge.stat.repository.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsarafajr on 23.08.14.
 */
@Service
public class TeamService {
    @Autowired
    private TeamDao teamDao;

    public ArrayList<TeamName> getAllNames() {
        List<TeamEntity> entities = teamDao.getAll();
        ArrayList<TeamName> teams = new ArrayList<>(entities.size());
        for (TeamEntity en : entities) {
            teams.add(new TeamName(en.getId(), en.getName()));
        }
        return teams;
    }

    public ArrayList<Team> getAll() {
        List<TeamEntity> entities = teamDao.getAll();
        ArrayList<Team> teams = new ArrayList<>(entities.size());
        for (TeamEntity en : entities) {
            teams.add(new Team(en.getId(), en.getName(),
                    en.getMatches(), en.getWins(), en.getImage()));
        }
        return teams;
    }
}
