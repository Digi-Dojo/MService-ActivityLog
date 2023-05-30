package com.startupsdigidojo.activitylog.userEvents.application.dto;

import com.startupsdigidojo.activitylog.userEvents.domain.NewUser;
import lombok.Getter;
import lombok.Setter;

public class NewUserEvent {
    @Setter
    @Getter
    private String type;

    @Setter @Getter
    private NewUser payload;
}
