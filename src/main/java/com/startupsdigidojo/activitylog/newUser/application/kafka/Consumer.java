package com.startupsdigidojo.activitylog.newUser.application.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Consumer {
    @Value("${com.startupsdigidojo.activitylog.newUser.application.kafka.consumer.topics.new_user}")
    private String newUserTopic;

    @KafkaListener(
            topics = "${com.startupsdigidojo.activitylog.newUser.application.kafka.consumer.topics.new_user}",
            groupId = "${com.startupsdigidojo.activitylog.newUser.application.kafka.consumer.group_id}"
    )
    public void consume(String jsonMessage) {
        System.out.println("Received:" + jsonMessage);
    }
}
