package com.startupsdigidojo.activitylog.startupEvents.application;

import com.startupsdigidojo.activitylog.startupEvents.application.dto.StartupEventDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
@Entity
public class StartupEvent {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String type;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private Time time;

    public StartupEvent(StartupEventDTO startupEventDTO) {
        type = startupEventDTO.getType();
        name = startupEventDTO.getPayload().getName();
        date = new Date(startupEventDTO.getPayload().getTime());
        time = new Time(startupEventDTO.getPayload().getTime());
    }

}
