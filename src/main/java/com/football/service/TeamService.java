package com.football.service;

import com.football.domain.League;
import com.football.domain.Match;
import com.football.domain.Player;
import com.football.domain.Team;
import com.football.repository.MatchRepository;
import com.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    public void CreateTeam(Team team){

        List<Player> players = new ArrayList<>();
        team.setPlayerList(players);

        teamRepository.save(team);
    }

    public void UpdateTeam(Team team, League league, Match match){

        List<Match> allmatches = new ArrayList<>();
        List<Match> matches1 = matchRepository.findByTeam1Equals(team.getName());
        List<Match> matches2 = matchRepository.findByTeam2Equals(team.getName());
        allmatches.addAll(matches1);
        allmatches.addAll(matches2);

        team.setMatchesPlayed(allmatches);
        team.setLeague(league);

        teamRepository.save(team);

    }

    public void UpdateSquad(Team team, Player player){
        List<Player> squad = team.getPlayerList();
        squad.add(player);
        team.setPlayerList(squad);

        teamRepository.save(team);
    }

    public void UpdateTeamLeague(Team team, League league){
        team.setLeague(league);
        teamRepository.save(team);
    }

    public List<Team> findByName(String name) {
        return teamRepository.findByNameLike(name);
    }

    public void deleteTeam(Team team){
        teamRepository.delete(team);
    }
}
