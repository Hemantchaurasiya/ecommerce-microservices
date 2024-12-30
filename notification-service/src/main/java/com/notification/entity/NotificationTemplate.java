package com.notification.entity;

import lombok.Data;

@Data
public class NotificationTemplate {
    private String id;
    private NotificationType type;
    private String subject;
    private String body;
}
