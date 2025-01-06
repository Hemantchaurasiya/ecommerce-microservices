package com.notification.service.serviceimpl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.dto.UserDto;
import com.notification.entity.NotificationEvent;
import com.notification.entity.NotificationTemplate;
import com.notification.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

    public void processNotification(String message) {
        NotificationEvent event = parseMessage(message);
        processEvent(event);
    }

    @Scheduled(fixedDelay = 60000)
    public void processRetries() {
        // Fetch failed notifications and retry sending them
    }

    private NotificationEvent parseMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, NotificationEvent.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse message", e);
        }
    }

    private void processEvent(NotificationEvent event) {
        // UserDto user = getUser(event.getUserId());
        // NotificationTemplate template = getTemplate(event.getType(), user.getPreferredChannel());
        // String message = generateMessage(template, event.getPayload());
        // sendNotification(user, template.getChannel(), message);
        // logNotification(event.getUserId(), event.getType(), template.getChannel());
    }

    private void sendNotification(UserDto user, String channel, String message) {
        switch (channel) {
            case "EMAIL":
                sendEmail(user,message);
                break;
            case "SMS":
                sendSms(user,message);
                break;
        }
    }

    private void sendEmail(UserDto user, String message) {
        // Send email
    }

    private void sendSms(UserDto user, String message) {
        // Send SMS
    }
}
