package com.popshk.controller;

import com.popshk.model.User;
import com.popshk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String registration(){ return "registration";}

    @PostMapping
    public String addUser(User user, Model model){

        User userFromDb=userRepository.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.addAttribute("message","User exists!");
            return "registration";
        }

        user.setActive(true);
        userRepository.save(user);

        return "redirect:/login";
    }
}
