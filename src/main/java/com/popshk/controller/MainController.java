package com.popshk.controller;

import com.popshk.model.User;
import com.popshk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    UserRepository repository;

    @GetMapping
    public String main (){return "main";}

    @GetMapping("/login")
    public String login(){ return "login";}

    @GetMapping("/registration")
    public String registration(){ return "registration";}

    @GetMapping("/chat")
    public String chat(){ return "chat";}

    @PostMapping
    public String  userSave (User user){
          repository.save(user);
          return "registration";
    }

    @PostMapping
    public String sendMessage(@RequestParam String text){
        return "chat";
    }
}