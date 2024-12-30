package com.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.notification.entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
