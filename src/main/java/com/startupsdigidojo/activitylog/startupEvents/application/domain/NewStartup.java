package com.startupsdigidojo.activitylog.startupEvents.application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.Date;

@RequiredArgsConstructor
@Entity
public class NewStartup {
    @Id
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private Long time;

    @Override
    public String toString() {
        return "NewStartup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + new Date(time) +
                '}';
    }
}
