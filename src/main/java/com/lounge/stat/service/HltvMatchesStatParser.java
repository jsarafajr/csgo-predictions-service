package com.lounge.stat.service;

import com.lounge.stat.repository.MatchDao;
import com.lounge.stat.repository.StatisticDao;
import com.lounge.stat.repository.TeamDao;
import com.lounge.stat.model.MatchEntity;
import com.lounge.stat.model.StatisticEntity;
import com.lounge.stat.model.TeamEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
* Created by jsarafajr on 11.08.14.
*/
@Service
public class HltvMatchesStatParser {
    private final int START_CHILD = 5;

    @Autowired
    private MatchDao matchDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private StatisticDao statisticDao;

    public void parse() {
        try {
            Document document = Jsoup.connect("http://www.hltv.org/?pageid=188&gameid=2")
                    .userAgent("Chrome").get();

            Element allMatchesDiv = document.getElementsByClass("covMainBoxContent")
                    .first().child(0);

            System.out.println("Matches parsing start...");
            for (int i = allMatchesDiv.children().size() - 1; i >= START_CHILD; i--) {
                Element matchDiv = allMatchesDiv.child(i);
                if (matchDiv.children().size() == 0) continue;
                MatchEntity currentMatch = parseMatch(matchDiv);
                if (matchDao.isExist(currentMatch)) {
                    addMatch(currentMatch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addMatch(MatchEntity match) {
        matchDao.save(match);

        TeamEntity team1 = match.getTeam1();
        TeamEntity team2 = match.getTeam2();

        if (!match.getScore1().equals(match.getScore2())) {
            team1.incrementMathces();
            team2.incrementMathces();
        }

        if (match.getScore1() > match.getScore2()) {
            team1.incrementWins();
        } else {
            if (match.getScore2() > match.getScore1()) {
                team2.incrementWins();
            }
        }

        teamDao.update(team1);
        teamDao.update(team2);

        System.out.println("Match add : ");
        System.out.println(match);
    }

    private MatchEntity parseMatch(Element element) {
        element = element.child(0); // div in div

        MatchEntity match = new MatchEntity();

        match.setDate(parseDate(element));

        String team1Name = parseTeam1Name(element);
        match.setTeam1(getTeamFromDB(team1Name));

        String team2Name = parseTeam2Name(element);
        match.setTeam2(getTeamFromDB(team2Name));

        match.setScore1(parseTeam1Score(element));
        match.setScore2(parseTeam2Score(element));

        return match;
    }

    private Timestamp parseDate(Element element) {
        element = element.child(0).child(0);

        String value = element.html().trim();
        int day = Integer.parseInt(
                value.substring(0, value.indexOf('/')));
        int mounth = Integer.parseInt(
                value.substring(value.indexOf('/') + 1, value.indexOf(' '))) - 1;
        int year = Integer.parseInt(
                "20" + value.substring(value.indexOf(' ') + 1, value.length()));

        return new Timestamp(new GregorianCalendar(year, mounth, day).getTimeInMillis());
    }

    private String parseTeam1Name(Element element) {
        element = element.child(1).child(0);
        String value = element.html();
        return value.substring(value.lastIndexOf('>') + 1, value.lastIndexOf('(')).trim();
    }

    private String parseTeam2Name(Element element) {
        element = element.child(2).child(0);
        String value = element.html();
        return value.substring(value.lastIndexOf('>') + 1, value.lastIndexOf('(')).trim();
    }

    private int parseTeam1Score(Element element) {
        element = element.child(1).child(0);
        String value = element.html();
        return Integer.parseInt(
                value.substring(value.lastIndexOf('(') + 1, value.lastIndexOf(')')));
    }

    private int parseTeam2Score(Element element) {
        element = element.child(2).child(0);
        String value = element.html();
        return Integer.parseInt(
                value.substring(value.lastIndexOf('(') + 1, value.lastIndexOf(')')));
    }

    private TeamEntity getTeamFromDB(String teamName) {
        TeamEntity team = teamDao.get(teamName);

        if (team == null) {
            team = new TeamEntity();
            team.setName(teamName);
            team.setMatches(0);
            team.setWins(0);
            teamDao.save(team);

            team = teamDao.get(teamName);

            System.out.println("Team add : " + teamName);
        }

        return team;
    }

    private StatisticEntity getStatisticFromDB(TeamEntity team) {
        StatisticEntity statistic = statisticDao.getTeamStatistic(team);

        if (statistic == null) {
            statistic = new StatisticEntity();
            statistic.setTeam(team);
            statisticDao.addTeamStatistic(statistic);

            statistic = statisticDao.getTeamStatistic(team);
        }

        return statistic;
    }
}
