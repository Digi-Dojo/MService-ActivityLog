package com.startupsdigidojo.activitylog.userEvents.application.kafka;

import com.startupsdigidojo.activitylog.userEvents.application.dto.NewUserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConsumer {

    @KafkaListener(
            containerFactory = "newUserEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.newUser.application.kafka.UserConsumer.topics.new_user}",
            groupId = "${com.startupsdigidojo.activitylog.newUser.application.kafka.consumer.group_id}"
    )
    public void consume(NewUserEvent newUserEvent) {
        System.out.println(newUserEvent.getPayload());
    }
}
