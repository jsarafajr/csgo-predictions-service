package com.lounge.stat.controller;

import com.lounge.stat.dto.Match;
import com.lounge.stat.dto.Prediction;
import com.lounge.stat.service.MatchService;
import com.lounge.stat.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by jsarafajr on 24.08.14.
 */
@Controller
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private PredictionService predictionService;
    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/add-prediction", method = POST)
    @ResponseBody
    public void addPrediction(@RequestParam String name1, @RequestParam String name2,
                              @RequestParam int day, @RequestParam int month, @RequestParam int year) {

        predictionService.addNewPrediction(name1, name2, day, month, year);
    }

    @RequestMapping(value = "/get-all-predictions", method = GET)
    @ResponseBody
    public List<Prediction> getAll() {
        return predictionService.getAllOrdered();
    }

    @RequestMapping(value = "/get-versus-matches/{id}", method = GET)
    @ResponseBody
    public List<Match> getVersus(@PathVariable int id) {
        return matchService.getMatches(id);
    }

}
