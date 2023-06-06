package com.startupsdigidojo.activitylog.teamMemberEvents.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class TeamMemberEventDTO {
    public static class TeamMemberInfo {
        @Setter
        @Getter
        protected Long id;

        @Setter
        @Getter
        protected Long puser;

        @Setter
        @Getter
        protected Long startup;

        @Setter
        @Getter
        protected String role;

        @Setter
        @Getter
        protected Long time;
    }

    @Setter @Getter
    protected String type;

    @Setter @Getter
    protected TeamMemberInfo payload;

    @Override
    public String toString() {
        return "Team Member Event{" +
                "type='" + type + '\'' +
                "team member=" + payload.getId() +
                "time=" + new Date(payload.getTime()) +
                '}';
    }
}
