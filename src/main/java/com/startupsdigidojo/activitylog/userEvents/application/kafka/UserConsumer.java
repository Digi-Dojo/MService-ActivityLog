package com.startupsdigidojo.activitylog.userEvents.application.kafka;

import com.startupsdigidojo.activitylog.userEvents.application.ManageUserEvent;
import com.startupsdigidojo.activitylog.userEvents.application.UserEvent;
import com.startupsdigidojo.activitylog.userEvents.application.dto.NewUserEvent;
import com.startupsdigidojo.activitylog.userEvents.application.dto.UserLogInEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConsumer {
    private final ManageUserEvent manageUserEvent;

    @KafkaListener(
            containerFactory = "newUserEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.UserConsumer.topics.user.created}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncNewUser(NewUserEvent newUserEvent) {
        System.out.println(newUserEvent);
        manageUserEvent.saveUserEvent(new UserEvent(newUserEvent));
    }

    @KafkaListener(
            containerFactory = "userLogInEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.UserConsumer.topics.user.logged_in}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncUserLogIn(UserLogInEvent userLogInEvent) {
        System.out.println(userLogInEvent);
        manageUserEvent.saveUserEvent(new UserEvent(userLogInEvent));
    }
}
