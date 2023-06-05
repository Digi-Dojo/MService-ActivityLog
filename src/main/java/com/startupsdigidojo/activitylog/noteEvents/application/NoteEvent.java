package com.startupsdigidojo.activitylog.noteEvents.application;

import com.startupsdigidojo.activitylog.noteEvents.application.dto.NoteEventDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
@Entity
public class NoteEvent {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String type;

    @Setter @Getter
    private Long note;

    @Setter @Getter
    private String text;

    @Setter @Getter
    private Long place;

    @Setter @Getter
    private Date date;

    @Setter @Getter
    private Boolean statusAdded;

    @Setter @Getter
    private Time time;

    public NoteEvent(NoteEventDTO noteEventDTO){
        type = noteEventDTO.getType();
        note = noteEventDTO.getPayload().getUuid();
        text = noteEventDTO.getPayload().getText();
        place = noteEventDTO.getPayload().getPlace();
        date = new Date(noteEventDTO.getPayload().getDate().getTime());
        statusAdded = noteEventDTO.getPayload().getStatusAdded();
        time = new Time(noteEventDTO.getPayload().getTime());
    }
}
