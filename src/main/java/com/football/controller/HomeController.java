package com.football.controller;


import com.football.domain.User;
import com.football.service.LeagueService;
import com.football.service.PlayerService;
import com.football.service.TeamService;
import com.football.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String showIndexPage(){
        return "index";
    }


    @GetMapping("/login")
    public String login(Model model)
    {
        return "loginForm";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());

        return "/registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "registerForm";
        }

        if(userService.isUserPresent(user.getEmail())){
            model.addAttribute("exists", true);
            return "registerForm";
        }
        else{
            userService.createUser(user);
            //return "registerForm";
            return  "succes";
        }
    }

    //cautarea dupa nume
    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name){

        model.addAttribute("users", userService.findByName("%" + name + "%"));
        return  "userslist";
    }

    @GetMapping("/leagues")
    public String listLeagues(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("leagues", leagueService.findByName("%" + name + "%"));

        return "leaguelist";
    }

    @GetMapping("/teams")
    public String listTeams(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("teams", teamService.findByName("%" + name + "%"));

        return "teamlist";
    }

    @GetMapping("/players")
    public String listPlayers(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("players", playerService.findByBothNames("%" + name + "%"));

        return "playerlist";
    }

    @GetMapping("/operations")
    public String operationsPanel(Model model)
    {
        return "operationsPanel";
    }
}
