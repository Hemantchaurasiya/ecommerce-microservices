package com.notification.entity;

import lombok.Data;

@Data
public class NotificationEvent {
    private String eventId;
    private NotificationType type;
    private String userId;
    private String payload;
}
