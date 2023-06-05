package com.startupsdigidojo.activitylog.placeEvents.application;

import com.startupsdigidojo.activitylog.placeEvents.application.dto.PlaceEventDTO;
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
public class PlaceEvent {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String type;

    @Setter @Getter
    private Long place;

    @Setter @Getter
    private String placeType;

    @Setter @Getter
    private Long startup;

    @Setter @Getter
    private Date date;

    @Setter @Getter
    private Time time;

    public PlaceEvent(PlaceEventDTO placeEventDTO){
        type = placeEventDTO.getType();
        place = placeEventDTO.getPayload().getUuid();
        placeType = placeEventDTO.getPayload().getType();
        startup = placeEventDTO.getPayload().getStartup();
        date = new Date(placeEventDTO.getPayload().getTime());
        time = new Time(placeEventDTO.getPayload().getTime());
    }

}
