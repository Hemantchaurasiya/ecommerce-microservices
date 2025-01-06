package com.notification.entity;

import java.time.LocalDateTime;

import com.notification.enums.NotificationChannel;
import com.notification.enums.NotificationStatus;
import com.notification.enums.NotificationType;

import lombok.Data;

@Data
public class Notification {
    private String id;
    private String userId;
    private String message;
    private NotificationType type;
    private NotificationChannel channel;
    private NotificationStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
}
