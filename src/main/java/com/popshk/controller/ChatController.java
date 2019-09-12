package com.popshk.controller;

import com.popshk.model.Message;
import com.popshk.model.User;
import com.popshk.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String chat(Model model){
        List <Message> messages = messageRepository.findAll();
        for (int i=0;i<messages.size();i++){
            String date = messages.get(i).getDate().substring(9);
            String text = messages.get(i).getText();
            String user = messages.get(i).getUserName();
                messages.set(i,new Message(text,date,user));
        }
        model.addAttribute("messages",messages);
        return "chat";
    }

    @PostMapping
    public String sendMessage(@AuthenticationPrincipal User user, @RequestParam String text){
        String userName = user.getUsername();

        SimpleDateFormat dateFormat =new SimpleDateFormat();
        String data = dateFormat.format(new Date());

        Message message = new Message(text,data,userName);
        messageRepository.save(message);
        return "redirect:/chat";
    }
}
