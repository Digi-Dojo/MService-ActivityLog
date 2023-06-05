package com.startupsdigidojo.activitylog.startupEvents.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageStartupEvent {
    private final StartupEventRepository startupEventRepository;

    @Autowired
    public ManageStartupEvent(StartupEventRepository startupEventRepository) {this.startupEventRepository = startupEventRepository;}

    public void saveStartupEvent(StartupEvent startupEvent) {startupEventRepository.save(startupEvent);}
}
