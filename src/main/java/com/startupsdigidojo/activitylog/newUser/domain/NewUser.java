package com.startupsdigidojo.activitylog.newUser.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Entity
public class NewUser {
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
        return "NewUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", time=" + new Date(time) +
                '}';
    }
}
