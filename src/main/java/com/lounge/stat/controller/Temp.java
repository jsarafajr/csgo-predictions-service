package com.lounge.stat.controller;

import com.lounge.stat.model.TeamEntity;
import com.lounge.stat.repository.TeamDao;
import com.lounge.stat.service.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by jsarafajr on 22.08.14.
 */
@Controller
public class Temp {

    @Autowired
    private Calculation calculation;
    @Autowired
    private TeamDao dao;

    @RequestMapping(value = "test", method = GET, produces = "application/json")
    public @ResponseBody java.util.List<TeamEntity> tmp() {
        return dao.getAll();
    }
}
