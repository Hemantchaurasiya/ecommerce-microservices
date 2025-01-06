package com.notification.entity;

import com.notification.enums.NotificationChannel;
import com.notification.enums.NotificationType;

import lombok.Data;

@Data
public class NotificationEvent {
    private String userId;
    private String title;
    private String subject;
    private String body;
    private NotificationType type;
    private NotificationChannel channel;
}
