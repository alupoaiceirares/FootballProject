package com.football.service;

import com.football.domain.Match;
import com.football.domain.Round;
import com.football.domain.Team;
import com.football.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public void CreateMatch(Match match){

        List<Team> teams = new ArrayList<>();
        match.setMatchTeamList(teams);
        matchRepository.save(match);
    }

    public void UpdateMatch(Match match, Team team1, Team team2){

        List<Team> teams = match.getMatchTeamList();
        teams.add(team1);
        teams.add(team2);

        match.setMatchTeamList(teams);

        match.setTeam1(team1.getName());
        match.setTeam2(team2.getName());

        matchRepository.save(match);

    }

    public void UpdateMatchRound(Round round, Match match){
        match.setRound(round);
        matchRepository.save(match);
    }

    public Match findById(int id){

        return matchRepository.findById(id);
    }
}
