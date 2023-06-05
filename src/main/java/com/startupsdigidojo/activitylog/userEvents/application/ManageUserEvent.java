package com.startupsdigidojo.activitylog.userEvents.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUserEvent {
    private final UserEventRepository userEventRepository;

    @Autowired
    public ManageUserEvent(UserEventRepository userEventRepository) {
        this.userEventRepository = userEventRepository;
    }

    public void saveUserEvent(UserEvent userEvent){
        userEventRepository.save(userEvent);
    }
}
