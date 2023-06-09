package com.startupsdigidojo.activitylog.userEvents.application;

import com.startupsdigidojo.activitylog.userEvents.application.dto.UserEventDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
@Entity
public class UserEvent {
    @Id @Setter @Getter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String type;

    @Setter @Getter
    private String mailAddress;

    @Setter @Getter
    private Date date;

    @Setter @Getter
    private Time time;

    public UserEvent(UserEventDTO userEventDTO){
        type = userEventDTO.getType();
        mailAddress = userEventDTO.getPayload().getMailAddress();
        date = new Date(userEventDTO.getPayload().getTime());
        time = new Time(userEventDTO.getPayload().getTime());
    }
}
