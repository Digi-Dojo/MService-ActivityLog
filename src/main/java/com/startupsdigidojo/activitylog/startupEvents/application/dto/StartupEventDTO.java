package com.startupsdigidojo.activitylog.startupEvents.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class StartupEventDTO {

    public static class StartupInfo {
        @Getter @Setter
        protected Long id;

        @Getter @Setter
        protected String name;

        @Getter @Setter
        protected String description;

        @Getter @Setter
        protected Long time;
    }

    @Getter @Setter
    protected String type;

    @Getter @Setter
    protected StartupInfo payload;

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                "startup=" + payload.name +
                "time=" + new Date(payload.getTime()) +
                '}';
    }
}
