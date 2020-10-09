package com.football;

import com.football.domain.League;
import com.football.domain.Player;
import com.football.domain.Team;
import com.football.domain.User;
import com.football.service.LeagueService;
import com.football.service.PlayerService;
import com.football.service.TeamService;
import com.football.service.UserService;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.junit.jupiter.api.AfterEach;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FotbalApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private LeagueService leagueService;

    @BeforeEach
    public void initDB(){
        User user1 = new User("test@gmail.com", "testfirst", "testlast", "123456");
        userService.createUser(user1);
        User user2 = new User("test2@gmail.com", "test2first", "test2last", "123456");
        userService.createAdmin(user2);

        Player player1 = new Player("player1first", "player1last", 23, "RW");
        Player player2 = new Player("player2first", "player2last", 29, "GK");

        playerService.createPlayer(player1);
        playerService.createPlayer(player2);


        Team team1 = new Team("Manchester United", 0);
        teamService.CreateTeam(team1);

        Team team2 = new Team("Manchester City", 0 );
        teamService.CreateTeam(team2);


        League league = new League("Premier League", "England");
        leagueService.CreateLeague(league);
        leagueService.UpdateLeague(league, team1);
        leagueService.UpdateLeague(league,team2);

        teamService.UpdateSquad(team1, player1);


        teamService.UpdateSquad(team2,player2);

        teamService.UpdateTeamLeague(team1,league);
        teamService.UpdateTeamLeague(team2,league);
    }

    @Test
    public void testUser(){
        User admin = userService.findById("test2@gmail.com");
        assertNotNull(admin);
        User user = userService.findById("test@gmail.com");
        assertEquals(user.getEmail(), "test@gmail.com");
    }

    @Test
    public void testPlayer(){
        List<Player> players = new ArrayList<>();
        players = playerService.findByBothNamesExactly("player1first", "player1last");
        assertNotNull(players);
        assertEquals(1, players.size());
        List<Player> players2 = playerService.findByLastName("player2last");
        assertEquals(1,players2.size());
        assertEquals(players.get(0).getPosition(), "RW");
        assertEquals(players2.get(0).getPosition(), "GK");

    }

    @Test
    public void TestLeague(){
        List<League> leagues = new ArrayList<>();
        leagues = leagueService.findByName("Premier League");

        assertNotNull(leagues);
        League league = leagues.get(0);
        assertEquals(league.getCountry(), "England");


    }

    @Test
    public void TestTeam(){
        List<Team> teams = new ArrayList<>();
        teams = teamService.findByName("Manchester United");
        assertNotNull(teams);
        assertEquals(1, teams.size());
        Team team1 = teams.get(0);
        assertEquals(team1.getName(), "Manchester United");
        assertEquals(team1.getPoints(), 0 );
    }

    @AfterEach
    public void finalize(){
        List<Player> players = playerService.findByBothNamesExactly("player1first", "player1last");
        playerService.deletePlayer(players.get(0));
        List<Player> players2 = playerService.findByBothNamesExactly("player2first", "player2last");
        playerService.deletePlayer(players2.get(0));

        List<Team> teams = teamService.findByName("Manchester United");
        teamService.deleteTeam(teams.get(0));
        List<Team> teams2 = teamService.findByName("Manchester City");
        teamService.deleteTeam(teams2.get(0));

        List<League> leagues = leagueService.findByName("Premier League");
        leagueService.deleteLeague(leagues.get(0));
    }

}
