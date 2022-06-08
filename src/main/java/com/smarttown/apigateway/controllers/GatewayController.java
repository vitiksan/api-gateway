package com.smarttown.apigateway.controllers;

import com.smarttown.apigateway.services.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GatewayController {

    private KafkaProducer producer;

    @Autowired
    public GatewayController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/gateway/send", consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> sendMessage(@RequestParam String topic, @RequestBody String json){
        return producer.sendMessage(topic, json) ? ResponseEntity.ok("Message is sent!") : ResponseEntity.badRequest().body("Message is not sent!");
    }

    @GetMapping(value = "/gateway/check",produces = "text/html")
    public String checkApi(){
        return "hello world";
    }
}
