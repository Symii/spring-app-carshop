package me.symi.carshop.rest;

import me.symi.carshop.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public void sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
    }
}