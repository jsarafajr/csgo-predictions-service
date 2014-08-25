package com.lounge.stat.controller;

import com.lounge.stat.dto.Team;
import com.lounge.stat.dto.TeamName;
import com.lounge.stat.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jsarafajr on 23.08.14.
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    public TeamService teamService;

    @RequestMapping(value = "/get-all-names", method = GET, produces = "application/json")
    public @ResponseBody List<TeamName> getAllNames() {
        return teamService.getAllNames();
    }

    @RequestMapping(value = "/get-all", method = GET, produces = "application/json")
    public @ResponseBody List<Team> getAll() {
        return teamService.getAll();
    }

}
