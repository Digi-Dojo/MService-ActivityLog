package com.startupsdigidojo.activitylog.placeEvents.application.kafka;

import com.startupsdigidojo.activitylog.placeEvents.application.ManagePlaceEvent;
import com.startupsdigidojo.activitylog.placeEvents.application.PlaceEvent;
import com.startupsdigidojo.activitylog.placeEvents.application.dto.PlaceCreatedEvent;
import com.startupsdigidojo.activitylog.placeEvents.application.dto.PlaceDeletedEvent;
import com.startupsdigidojo.activitylog.placeEvents.application.dto.PlaceUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlaceConsumer {
    private final ManagePlaceEvent managePlaceEvent;

    @KafkaListener(
            containerFactory = "placeCreatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.placeEvents.application.kafka.PlaceConsumer.topics.place.created}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncPlaceCreated(PlaceCreatedEvent placeCreatedEvent){
        System.out.println(placeCreatedEvent);
        managePlaceEvent.savePlaceEvent(new PlaceEvent(placeCreatedEvent));
    }

    @KafkaListener(
            containerFactory = "placeDeletedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.placeEvents.application.kafka.PlaceConsumer.topics.place.deleted}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncPlaceDeleted(PlaceDeletedEvent placeDeletedEvent){
        System.out.println(placeDeletedEvent);
        managePlaceEvent.savePlaceEvent(new PlaceEvent(placeDeletedEvent));
    }

    @KafkaListener(
            containerFactory = "placeUpdatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.placeEvents.application.kafka.PlaceConsumer.topics.place.updated}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncPlaceUpdated(PlaceUpdatedEvent placeUpdatedEvent){
        System.out.println(placeUpdatedEvent);
        managePlaceEvent.savePlaceEvent(new PlaceEvent(placeUpdatedEvent));
    }
}
