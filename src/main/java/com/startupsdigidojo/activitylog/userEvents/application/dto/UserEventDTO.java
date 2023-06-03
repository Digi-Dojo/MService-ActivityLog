package com.startupsdigidojo.activitylog.userEvents.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UserEventDTO {
    public static class UserInfo {
        @Setter
        @Getter
        protected Long id;

        @Setter
        @Getter
        protected String name;

        @Setter
        @Getter
        protected String mailAddress;

        @Setter
        @Getter
        protected Long time;
    }

    @Setter @Getter
    protected String type;

    @Setter @Getter
    protected UserInfo payload;

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                "user=" + payload.mailAddress +
                "time=" + new Date(payload.getTime()) +
                '}';
    }
}
