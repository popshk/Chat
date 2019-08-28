package com.popshk.controller;

import com.popshk.model.Message;
import com.popshk.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String chat(Model model){
        Iterable <Message> messages = messageRepository.findAll();
        model.addAttribute("messages",messages);
        return "chat";
    }

    @PostMapping
    public String sendMessage(@RequestParam String text){
        Message message = new Message(text);
        messageRepository.save(message);
        return "redirect:/chat";
    }
}
