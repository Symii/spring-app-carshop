//package me.symi.carshop.service;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaConsumer {
//
//    @KafkaListener(topics = "chat_topic", groupId = "group_id")
//    public void consume(String message) {
//        System.out.println("Received message: " + message);
//    }
//}