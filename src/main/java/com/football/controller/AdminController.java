package com.football.controller;

import com.football.domain.League;
import com.football.domain.Player;
import com.football.domain.Team;
import com.football.service.LeagueService;
import com.football.service.PlayerService;
import com.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;


    @GetMapping("/addPlayer")
    public String addPlayer(Model model) {
        model.addAttribute("player", new Player());

        return "/playerAddForm";
    }

    @PostMapping("/addPlayer")
    public String registerUser(@Valid Player player, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "playerAddForm";
        }
        else{
            playerService.createPlayer(player);
            //return "registerForm";
            return "succes2";
        }
    }


    @GetMapping("/addLeague")
    public String addLeague(Model model) {
        model.addAttribute("league", new League());

        return "/leagueAddForm";
    }


    @PostMapping("/addLeague")
    public String registerUser(@Valid League league, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "leagueAddForm";
        }
        else{
            leagueService.CreateLeague(league);
            //return "registerForm";
            return "succes2";
        }
    }

    @GetMapping("/addTeam")
    public String addTeam(Model model) {
        model.addAttribute("team", new Team());

        return "/teamAddForm";
    }

    @PostMapping("/addTeam")
    public String addTeamPost(@Valid Team team, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "teamAddForm";
        }
        else{
            teamService.CreateTeam(team);
            //return "registerForm";
            return "succes2";
        }
    }

    @GetMapping("/addTeamToLeague")
    public String addTeamToLeague(Model model)
    {
        return "teamToLeagueForm";
    }



    @PostMapping("/addTeamToLeague")
    public String addTeamToLeaguePost(Model model, @RequestParam(defaultValue = "") String team, @RequestParam(defaultValue = "") String league){

        List<Team> teams = teamService.findByName(team);
        List<League> leagues = leagueService.findByName(league);
        if(teams.size()!= 1){
            model.addAttribute("existsteam", true);
            return "operationsPanel";
        }
        else{
            if(leagues.size() !=  1){
                model.addAttribute("existsleague", true);
                return "operationsPanel";
            }
            else{
                leagueService.UpdateLeague(leagues.get(0), teams.get(0));
                teamService.UpdateTeamLeague(teams.get(0), leagues.get(0));
                System.out.println(leagues.get(0).getName());
                System.out.println(teams.get(0).getName());
            }
        }

        return "operationsPanel";
    }


    @GetMapping("/addPlayerToTeam")
    public String addPlayerToTeam(Model model)
    {
        return "playerToTeamForm";
    }

    @PostMapping("/addPlayerToTeam")
    public String addPlayerToTeamPost(Model model, @RequestParam(defaultValue = "") String firstname,
                                      @RequestParam(defaultValue = "") String lastname,
                                      @RequestParam(defaultValue = "") String position,
                                      @RequestParam(defaultValue = "") String team){

        List<Team> teams = teamService.findByName(team);
        List<Player> players = playerService.findByBothNamesExactly(firstname,lastname);

        System.out.println(teams.size());
        System.out.println(players.size());

        if(teams.size()!= 1){
            model.addAttribute("moreteams", true);
            return "operationsPanel";
        }
        else{
            int i=0;
            while(i<players.size()){
                if(!players.get(i).getPosition().equals(position)){
                    players.remove(i);
                }
                else{
                    i+=1;
                }
            }
            System.out.println(players.size());
            if(players.size() !=  1){
                model.addAttribute("moreplayers", true);
                return "operationsPanel";
            }
            else{
                teamService.UpdateSquad(teams.get(0),players.get(0));
                playerService.updatePlayerTeam(players.get(0), teams.get(0));
                System.out.println(players.get(0).getFirstname() + " " + players.get(0).getLastname());
                System.out.println(teams.get(0).getName());
            }
        }

        return "operationsPanel";
    }

    @GetMapping("/deletePlayer")
    public String deletePlayer(Model model)
    {
        return "playerDeleteForm";
    }

    @PostMapping("/deletePlayer")
    public String deletePLayerPost(Model model, @RequestParam(defaultValue = "") String firstname,
                                      @RequestParam(defaultValue = "") String lastname,
                                      @RequestParam(defaultValue = "") String position){

        List<Player> players = playerService.findByBothNamesExactly(firstname,lastname);

        System.out.println(players.size());

        int i=0;
        while(i<players.size()){
            if(!players.get(i).getPosition().equals(position)){
                players.remove(i);
                }
            else{
                i+=1;
                }
            }
        System.out.println(players.size());
        if(players.size() !=  1){
            model.addAttribute("moreplayers", true);
            return "operationsPanel";
        }
        else{
                playerService.deletePlayer(players.get(0));
                System.out.println(players.get(0).getFirstname() + " " + players.get(0).getLastname());
            }

        return "operationsPanel";
    }

}