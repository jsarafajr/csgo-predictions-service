package com.lounge.stat.repository;

import com.lounge.stat.model.MatchEntity;
import com.lounge.stat.model.TeamEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jsarafajr on 14.08.14.
 */
@Repository
@Transactional
public class MatchDao extends GenericDao<MatchEntity> {

    @Override
    public MatchEntity get(MatchEntity match) {
        Session session = getSession();

        Query query = session.createQuery("from MatchEntity m where m.date=:date " +
                "and m.team1=:team1 and m.team2=:team2 and m.score1=:score1 and m.score2=:score2");
        query.setParameter("date", match.getDate());
        query.setParameter("team1", match.getTeam1());
        query.setParameter("team2", match.getTeam2());
        query.setParameter("score1", match.getScore1());
        query.setParameter("score2", match.getScore2());

        return (MatchEntity) query.uniqueResult();
    }

    @Override
    public List<MatchEntity> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(MatchEntity.class);
        criteria.addOrder(Order.desc("date"));
        return criteria.list();
    }

    public List<MatchEntity> getTeamsVersusMatches(TeamEntity team1, TeamEntity team2, int count) {
        Session session = getSession();

        Query query = session.createQuery("from MatchEntity m where (m.team1=:team1 and m.team2=:team2) " +
                "or (m.team1=:team2 and m.team2=:team1) order by m.date desc ");

        query.setParameter("team1", team1);
        query.setParameter("team2", team2);

        if (count != -1) query.setMaxResults(count);

        return query.list();
    }

    public List<MatchEntity> getTeamsVersusMatches(TeamEntity team1, TeamEntity team2) {
        return getTeamsVersusMatches(team1, team2, -1);
    }

    public List<MatchEntity> getTeamMatches(TeamEntity team, int count) {
        Session session = getSession();

        Query query = session.createQuery("from MatchEntity where team1=:team or team2=:team order by date desc ");
        query.setParameter("team", team);

        if (count != -1) query.setMaxResults(count);

        return query.list();
    }

    public List<MatchEntity> getTeamMatches(TeamEntity team) {
        return getTeamMatches(team, -1);
    }
}
