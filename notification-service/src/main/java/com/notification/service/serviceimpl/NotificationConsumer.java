package com.notification.service.serviceimpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notification.service.NotificationService;

@Service
public class NotificationConsumer {
    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "notification-events", groupId = "notification-service")
    public void consumeNotification(String message) {
        System.out.println("Received message: " + message);
        notificationService.processNotification(message);
    }
}
