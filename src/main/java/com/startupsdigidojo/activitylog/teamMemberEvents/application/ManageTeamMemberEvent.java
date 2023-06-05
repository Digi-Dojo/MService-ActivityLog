package com.startupsdigidojo.activitylog.teamMemberEvents.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageTeamMemberEvent {
    private final TeamMemberEventRepository teamMemberEventRepository;

    @Autowired
    public ManageTeamMemberEvent(TeamMemberEventRepository teamMemberEventRepository) {
        this.teamMemberEventRepository = teamMemberEventRepository;
    }

    public void saveTeamMemberEvent(TeamMemberEvent teamMemberEvent){
        teamMemberEventRepository.save(teamMemberEvent);
    }
}
