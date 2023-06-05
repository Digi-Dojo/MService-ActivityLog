package com.startupsdigidojo.activitylog.userEvents.application.kafka;

import com.startupsdigidojo.activitylog.userEvents.application.ManageUserEvent;
import com.startupsdigidojo.activitylog.userEvents.application.UserEvent;
import com.startupsdigidojo.activitylog.userEvents.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConsumer {
    private final ManageUserEvent manageUserEvent;

    @KafkaListener(
            containerFactory = "userCreatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.UserConsumer.topics.user.created}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncUserCreated(UserCreatedEvent userCreatedEvent) {
        System.out.println(userCreatedEvent);
        manageUserEvent.saveUserEvent(new UserEvent(userCreatedEvent));
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

    @KafkaListener(
            containerFactory = "userLogOutEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.UserConsumer.topics.user.logged_out}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncUserLogIn(UserLogOutEvent userLogOutEvent) {
        System.out.println(userLogOutEvent);
        manageUserEvent.saveUserEvent(new UserEvent(userLogOutEvent));
    }

    @KafkaListener(
            containerFactory = "userDeletedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.UserConsumer.topics.user.deleted}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncUserDeleted(UserDeletedEvent userDeletedEvent) {
        System.out.println(userDeletedEvent);
        manageUserEvent.saveUserEvent(new UserEvent(userDeletedEvent));
    }

    @KafkaListener(
            containerFactory = "userUpdatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.UserConsumer.topics.user.updated}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncUserUpdated(UserUpdatedEvent userUpdatedEvent) {
        System.out.println(userUpdatedEvent);
        manageUserEvent.saveUserEvent(new UserEvent(userUpdatedEvent));
    }
}
