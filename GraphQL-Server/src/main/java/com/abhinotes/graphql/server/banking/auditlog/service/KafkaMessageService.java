package com.abhinotes.graphql.server.banking.auditlog.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaMessageService {

    private List<Message> messages = new ArrayList<>();

    @KafkaListener(topics = "test-topic", groupId = "graphql-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        messages.add(new Message(null, message)); // Add message to the list
    }

    public List<Message> getMessages(String topic) {
        // Here we are returning all messages; for specific topic handling, modify accordingly
        return new ArrayList<>(messages);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Message {
    private String key;
    private String value;
}