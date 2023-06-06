package com.startupsdigidojo.activitylog.startupEvents.application.kafka;

import com.startupsdigidojo.activitylog.startupEvents.application.ManageStartupEvent;
import com.startupsdigidojo.activitylog.startupEvents.application.StartupEvent;
import com.startupsdigidojo.activitylog.startupEvents.application.dto.StartupCreatedEvent;
import com.startupsdigidojo.activitylog.startupEvents.application.dto.StartupDeletedEvent;
import com.startupsdigidojo.activitylog.startupEvents.application.dto.StartupUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StartupConsumer {
    private final ManageStartupEvent manageStartupEvent;

    @KafkaListener(
            containerFactory = "startupCreatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.startupEvents.application.kafka.StartupCOnsumer.topics.startup.created}",
            groupId = "${com.startupsdigidojo.activitylog.startupEvents.application.kafka.consumer.group_id}"
    )
    public void syncNewStartup(StartupCreatedEvent startupCreatedEvent) {
        System.out.println(startupCreatedEvent);
        manageStartupEvent.saveStartupEvent(new StartupEvent(startupCreatedEvent));
    }

    @KafkaListener(
            containerFactory = "startupDeletedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.startupEvents.application.kafka.startupConsumer.topics.startup.deleted}",
            groupId = "${com.startupsdigidojo.activitylog.startupEvents.application.kafka.consumer.group_id}"
    )
    public void syncStartupDeleted(StartupDeletedEvent startupDeletedEvent) {
        System.out.println(startupDeletedEvent);
        manageStartupEvent.saveStartupEvent(new StartupEvent(startupDeletedEvent));
    }

    @KafkaListener(
            containerFactory = "startupUpdatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.startupEvents.application.kafka.startupConsumer.topics.startup.updated}",
            groupId = "${com.startupsdigidojo.activitylog.startupEvents.application.kafka.consumer.group_id}"
    )
    public void syncStartupUpdated(StartupUpdatedEvent startupUpdatedEvent) {
        System.out.println(startupUpdatedEvent);
        manageStartupEvent.saveStartupEvent(new StartupEvent(startupUpdatedEvent));
    }
}
