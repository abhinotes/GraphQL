package com.abhinotes.graphql.server.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("kafka/produce")
public class KafkaProducerController {

    // Autowiring Kafka Template
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${downstream.kafka.product-offer-topic}")
    private String topicToProduceMessage;

    // Publish messages using the GetMapping
    @PostMapping("")
    public String publishMessage(@RequestBody String message) {
        // Sending the message
        kafkaTemplate.send(topicToProduceMessage, UUID.randomUUID().toString(), message);
        return "Published Successfully";
    }

}
