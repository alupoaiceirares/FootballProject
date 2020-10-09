package com.football;

import com.football.domain.*;
import com.football.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FotbalApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private RoundService roundService;

    @Autowired
    private LeagueService leagueService;

    public static void main(String[] args) {

        SpringApplication.run(FotbalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        User newAdmin = new User("admin@yahoo.com", "AdminFirstName","AdminLastName", "123456");
        userService.createAdmin(newAdmin);

        User newUser = new User("user@gmail.com", "UserFirstName", "UserLastName", "123456");
        userService.createUser(newUser);

        /*
        Player player1 = new Player("Lionel", "Messi", 32, "CAM");
        playerService.createPlayer(player1);

        Player player2 = new Player("Bruno", "Fernandes", 28, "CAM");
        playerService.createPlayer(player2);

        Player player3 = new Player("Romero", "Lukaku", 29, "ST");
        playerService.createPlayer(player3);

        Player player4 = new Player("David", "De Gea", 27, "GK");
        playerService.createPlayer(player4);

        Player player5 = new Player("Raheem", "Sterling", 25, "RW");
        playerService.createPlayer(player5);

        Team team1 = new Team("Manchester United", 0);
        teamService.CreateTeam(team1);

        Team team2 = new Team("Manchester City", 0 );
        teamService.CreateTeam(team2);

        League league = new League("Premier League", "England");
        leagueService.CreateLeague(league);
        leagueService.UpdateLeague(league, team1);
        leagueService.UpdateLeague(league,team2);

        teamService.UpdateSquad(team1, player2);
        teamService.UpdateSquad(team1, player3);
        teamService.UpdateSquad(team1,player4);

        teamService.UpdateSquad(team2,player1);
        teamService.UpdateSquad(team2,player5);

        Round round1 = new Round();
        roundService.createRound(round1);

        Match match = new Match();
        matchService.CreateMatch(match);
        Match match1 = matchService.findById(match.getId());
        matchService.UpdateMatch(match1, team1, team2);

        teamService.UpdateTeam(team1, league, match1);
        teamService.UpdateTeam(team2, league, match1);

        roundService.updateRound(round1,match1);
        matchService.UpdateMatchRound(round1,match1);

*/



    }

}
