package com.startupsdigidojo.activitylog.placeEvents.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class PlaceEventDTO {
    public static class PlaceInfo{
        @Setter @Getter
        protected Long uuid;

        @Setter @Getter
        protected String type;

        @Setter @Getter
        protected Long startup;

        @Setter @Getter
        protected Long time;
    }

    @Setter @Getter
    protected String type;

    @Setter @Getter
    protected PlaceInfo payload;

    @Override
    public String toString() {
        return "Place Event{" +
                "type='" + type + '\'' +
                ", place=" + payload.uuid +
                ", place type=" + payload.type +
                ", startup=" + payload.startup +
                ", time=" + new Date(payload.time) +
                '}';
    }
}
