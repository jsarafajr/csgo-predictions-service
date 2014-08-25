package com.lounge.stat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by jsarafajr on 24.08.14.
 */
@Controller
public class PagesMapping {

    @RequestMapping(value = {"/", "index.jsp", "index.html"}, method = GET)
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/add_match", method = GET)
    public ModelAndView addMatchPage() {
        return new ModelAndView("add_match");
    }

    @RequestMapping(value = "/all_teams", method = GET)
    public ModelAndView allTeamsPage() {
        return new ModelAndView("all_teams");
    }
}
