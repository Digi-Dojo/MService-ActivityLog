package com.startupsdigidojo.activitylog.noteEvents.application.kafka;

import com.startupsdigidojo.activitylog.noteEvents.application.ManageNoteEvent;
import com.startupsdigidojo.activitylog.noteEvents.application.NoteEvent;
import com.startupsdigidojo.activitylog.noteEvents.application.dto.NoteCreatedEvent;
import com.startupsdigidojo.activitylog.noteEvents.application.dto.NoteDeletedEvent;
import com.startupsdigidojo.activitylog.noteEvents.application.dto.NoteUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NoteConsumer {
    private final ManageNoteEvent manageNoteEvent;

    @KafkaListener(
            containerFactory = "noteCreatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.noteEvents.application.kafka.NoteConsumer.topics.note.created}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncNoteCreated(NoteCreatedEvent noteCreatedEvent){
        System.out.println(noteCreatedEvent);
        manageNoteEvent.saveNoteEvent(new NoteEvent(noteCreatedEvent));
    }

    @KafkaListener(
            containerFactory = "noteDeletedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.noteEvents.application.kafka.NoteConsumer.topics.note.deleted}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncNoteDeleted(NoteDeletedEvent noteDeletedEvent){
        System.out.println(noteDeletedEvent);
        manageNoteEvent.saveNoteEvent(new NoteEvent(noteDeletedEvent));
    }

    @KafkaListener(
            containerFactory = "noteUpdatedEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.noteEvents.application.kafka.NoteConsumer.topics.note.updated}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncNoteUpdated(NoteUpdatedEvent noteUpdatedEvent){
        System.out.println(noteUpdatedEvent);
        manageNoteEvent.saveNoteEvent(new NoteEvent(noteUpdatedEvent));
    }
}
