package com.notification.service;
import com.notification.entity.NotificationEvent;

public interface NotificationService {
    public void processEvent(NotificationEvent event);
    public void processRetries();
}
