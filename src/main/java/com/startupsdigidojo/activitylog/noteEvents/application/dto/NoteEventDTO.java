package com.startupsdigidojo.activitylog.noteEvents.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class NoteEventDTO {
    public static class NoteInfo{
        @Setter @Getter
        protected Long uuid;

        @Setter @Getter
        protected String text;

        @Setter @Getter
        protected Long place;

        @Setter @Getter @JsonFormat(pattern = "dd/MM/yyyy")
        protected Date date;

        @Setter @Getter
        protected Boolean statusAdded;

        @Setter @Getter
        protected Long time;
    }

    @Setter @Getter
    protected String type;

    @Setter @Getter
    protected NoteInfo payload;

    @Override
    public String toString() {
        return "Note Event{" +
                "type='" + type + '\'' +
                ", note=" + payload.uuid +
                ", text=" + payload.text +
                ", place=" + payload.place +
                ", date=" + payload.date +
                ", statusAdded=" + payload.statusAdded +
                ", time=" + new Date(payload.time) +
                '}';
    }
}
