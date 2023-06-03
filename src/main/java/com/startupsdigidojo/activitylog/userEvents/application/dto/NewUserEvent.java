package com.startupsdigidojo.activitylog.userEvents.application.dto;

import lombok.Getter;
import lombok.Setter;

public class NewUserEvent extends UserEventDTO{

    @Setter @Getter
    private String type;

    @Setter @Getter
    private UserInfo payload;
}
