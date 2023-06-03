package com.startupsdigidojo.activitylog.userEvents.application.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UserLogInEvent {

    public class Payload{
        @Id
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

        @Override
        public String toString() {
            return "UserLogIn{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", mailAddress='" + mailAddress + '\'' +
                    ", time=" + new Date(time) +
                    '}';
        }
    }

    @Setter
    @Getter
    private String type;

    @Setter @Getter
    private Payload payload;
}
