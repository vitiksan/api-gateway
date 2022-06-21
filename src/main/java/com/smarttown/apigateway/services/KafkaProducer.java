package com.smarttown.apigateway.services;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Map<String, String> SENSOR_ID_PROPERTY = new HashMap<>();

    static {
        SENSOR_ID_PROPERTY.put("electricity", "meterId");
        SENSOR_ID_PROPERTY.put("gas", "sensor_id");
        SENSOR_ID_PROPERTY.put("water_usage", "sensorId");
    }


    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean sendMessage(String topicName, String jsonMessage) {
        JSONObject json = (JSONObject) JSONValue.parse(jsonMessage);
        String key = (String) json.get(SENSOR_ID_PROPERTY.get(topicName));

        if (key == null) {
            logger.error("Cannot get sensor id from json");
            return false;
        }

        logger.info("Send message to '{}' topic, wit key={}", topicName, key);
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topicName, key, jsonMessage);
        //TODO: maybe some checks needed (like check for topic existing)
        //TODO: we also may need custom exception added


//        while (!result.isDone()){
//            Thread.sleep(10);
//        }
        return !result.isCancelled();
    }
}
