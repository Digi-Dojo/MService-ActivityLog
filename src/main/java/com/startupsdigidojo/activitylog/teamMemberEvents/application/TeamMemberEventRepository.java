package com.startupsdigidojo.activitylog.teamMemberEvents.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberEventRepository extends JpaRepository<TeamMemberEvent,Long> {

}
