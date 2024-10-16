package com.abhinotes.graphql.server.banking.notification.service;

import com.abhinotes.graphql.server.banking.notification.model.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class NotificationServiceCore {

    private final String notificationTopic;
    private List<NotificationMessage> messages = new ArrayList<>();

    public NotificationServiceCore(@Value("${downstream.kafka.product-offer-topic}")  String notificationTopic) {
        this.notificationTopic = notificationTopic;
    }

    //@KafkaListener(topics = "product-offers", groupId = "graphql-group")
    @KafkaListener(topics = "product-offers", groupId = "graphql-group")
    public void listen(String message) {
        log.debug("Received message : {}" , message);
        //TODO Populate Message Key
        messages.add(new NotificationMessage(null, message)); // Add message to the list
    }
    public List<NotificationMessage> getMessages() {
        // Here we are returning all messages; for specific topic handling, modify accordingly
        return new ArrayList<>(messages);
    }
}
