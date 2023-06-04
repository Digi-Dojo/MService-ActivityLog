package com.startupsdigidojo.activitylog.startupEvents.application.dto;

import com.startupsdigidojo.activitylog.startupEvents.application.domain.NewStartup;

import lombok.Getter;
import lombok.Setter;

public class NewStartupEvent {
    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private NewStartup payload;
}
