package com.startupsdigidojo.activitylog.userEvents.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageNewUser {
    private final NewUserRepository newUserRepository;

    @Autowired
    public ManageNewUser(NewUserRepository newUserRepository) {
        this.newUserRepository = newUserRepository;
    }
}
