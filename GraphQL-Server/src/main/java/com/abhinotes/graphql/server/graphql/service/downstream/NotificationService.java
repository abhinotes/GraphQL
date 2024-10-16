package com.abhinotes.graphql.server.graphql.service.downstream;

import com.abhinotes.graphql.server.banking.notification.model.NotificationMessage;
import com.abhinotes.graphql.server.banking.notification.service.NotificationServiceCore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificationService {

    private final NotificationServiceCore notificationServiceCore;

    public NotificationService(NotificationServiceCore notificationServiceCore) {
        this.notificationServiceCore = notificationServiceCore;
    }


    public List<NotificationMessage> newNotifications() {
        return notificationServiceCore.getMessages();
    }
}
