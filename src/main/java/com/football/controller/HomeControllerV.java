package com.football.controller;

//import com.football.domain.PasswordResetToken;
import com.football.domain.User;
import com.football.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

//@Controller
public class HomeControllerV {

   /* @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showIndexPage(){
        return "index";
    }


    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("classActiveLogin", true);
        return "LoginRegisterRecover";
    }

    @GetMapping("/newUser")
    public String newUser(
            Locale locale,
            @RequestParam("token") String token,
            Model model) {
        PasswordResetToken passToken = userService.getPasswordResetToken(token);

        if (passToken == null) {
            String message = "Invalid token";   *//*user can be found by a token*//*
            model.addAttribute("message",message);
            return "redirect:/badRequest"; *//*general erro page*//*
        }
        model.addAttribute("classActiveEdit", true);

        return "myProfile";
    }
*/



}
