package com.notification.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Notification {
    private String id;
    private String userId;
    private NotificationType type;
    private String message;
    private NotificationChannel channel;
    private NotificationStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
}
