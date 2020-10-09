package com.football.service;

import com.football.domain.League;
import com.football.domain.Team;
import com.football.domain.User;
import com.football.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public void CreateLeague(League league){

        List<Team> teams = new ArrayList<>();
        league.setTeamList(teams);
        leagueRepository.save(league);

    }
    public void UpdateLeague(League league, Team team){
        List<Team> teams = league.getTeamList();
        System.out.println(teams.size());

        teams.add(team);
        System.out.println(team.getName());

        league.setTeamList(teams);
        System.out.println(teams.size());

        long noOfTeams = teams.size();
        System.out.println("NoofTeams" + noOfTeams);
        long noOfRounds = noOfTeams * 2 - 2 ;
        league.setNoOfTeams(noOfTeams);
        league.setNoOfRounds(noOfRounds);
        leagueRepository.save(league);
    }
    public List<League> findByName(String name) {
        return leagueRepository.findByNameLike(name);
    }

    public void deleteLeague(League league){
        leagueRepository.delete(league);
    }
}
