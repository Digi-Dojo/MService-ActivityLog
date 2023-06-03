package com.startupsdigidojo.activitylog.userEvents.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UserEventDTO {
    public class UserInfo {
        @Setter
        @Getter
        private Long id;

        @Setter
        @Getter
        private String name;

        @Setter
        @Getter
        private String mailAddress;

        @Setter
        @Getter
        private Long time;
    }

    @Setter @Getter
    private String type;

    @Setter @Getter
    private UserInfo payload;

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                "user=" + payload.mailAddress +
                "time=" + new Date(payload.getTime()) +
                '}';
    }
}
