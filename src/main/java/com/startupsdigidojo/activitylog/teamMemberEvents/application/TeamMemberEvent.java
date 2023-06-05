package com.startupsdigidojo.activitylog.teamMemberEvents.application;

import com.startupsdigidojo.activitylog.teamMemberEvents.application.dto.TeamMemberEventDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
@Entity
public class TeamMemberEvent {
    @Id @Setter @Getter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String type;

    @Setter @Getter
    private Long teamMember;

    @Setter @Getter
    private Long puser;

    @Setter @Getter
    private Long startup;

    @Setter @Getter
    private String role;

    @Setter @Getter
    private Date date;

    @Setter @Getter
    private Time time;

    public TeamMemberEvent(TeamMemberEventDTO teamMemberEventDTO) {
        type = teamMemberEventDTO.getType();
        teamMember = teamMemberEventDTO.getPayload().getId();
        puser = teamMemberEventDTO.getPayload().getPuser();
        startup = teamMemberEventDTO.getPayload().getStartup();
        role = teamMemberEventDTO.getPayload().getRole();
        date = new Date(teamMemberEventDTO.getPayload().getTime());
        time = new Time(teamMemberEventDTO.getPayload().getTime());
    }
}
