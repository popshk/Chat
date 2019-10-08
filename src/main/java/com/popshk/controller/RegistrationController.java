package com.popshk.controller;

import com.popshk.model.User;
import com.popshk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String registration(){ return "registration";}

    @PostMapping
    public String addUser(User user, Model model, @RequestParam String username){

        User userFromDb=userRepository.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.addAttribute("message","User exists!");
            if (username.equals(userFromDb))
                model.addAttribute("message","User exist!");
            if (username.isEmpty() || username.length()<3)
                model.addAttribute("message","Invalid User Name!");
            return "registration";
        }

        user.setActive(true);
        userRepository.save(user);

        return "redirect:/login";
    }
}
