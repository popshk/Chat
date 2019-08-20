package com.popshk.controller;

import com.popshk.model.Message;
import com.popshk.model.User;
import com.popshk.repository.MessageRepository;
import com.popshk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String main (){return "main";}

    @GetMapping("/login")
    public String login(){ return "login";}

    @GetMapping("/registration")
    public String registration(){ return "registration";}

    @GetMapping("/chat")
    public String chat(Map<String,Object> model){
         Iterable <Message> messages = messageRepository.findAll();
         messages = messageRepository.findAll();
         model.put("messages",messages);

        return "chat";
    }

    @PostMapping
    public String  userSave (User user){
          userRepository.save(user);
          return "registration";
    }

    @PostMapping("/chat")
    public String sendMessage(@RequestParam String text, Map<String,Object> model){
        Message message = new Message(text);
        messageRepository.save(message);
        Iterable <Message> messages = messageRepository.findAll();
        model.put("messages",messages);
        return "redirect:/chat";
    }
}
