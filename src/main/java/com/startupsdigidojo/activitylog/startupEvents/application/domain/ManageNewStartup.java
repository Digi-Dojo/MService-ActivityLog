package com.startupsdigidojo.activitylog.startupEvents.application.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageNewStartup {
    private final NewStartupRepository newStartupRepository;

    @Autowired
    public ManageNewStartup(NewStartupRepository newStartupRepository) {
        this.newStartupRepository = newStartupRepository;
    }
}
