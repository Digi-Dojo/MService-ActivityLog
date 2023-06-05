package com.startupsdigidojo.activitylog.teamMemberEvents.application.kafka;

import com.startupsdigidojo.activitylog.teamMemberEvents.application.ManageTeamMemberEvent;
import com.startupsdigidojo.activitylog.teamMemberEvents.application.TeamMemberEvent;
import com.startupsdigidojo.activitylog.teamMemberEvents.application.dto.StartupAddedUserEvent;
import com.startupsdigidojo.activitylog.teamMemberEvents.application.dto.StartupRemovedUserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeamMemberConsumer {
    private final ManageTeamMemberEvent manageTeamMemberEvent;

    @KafkaListener(
            containerFactory = "startupAddedUserEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.teamMemberEvents.application.kafka.TeamMemberConsumer.topics.startup.added_user}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncStartupAddedUser(StartupAddedUserEvent startupAddedUserEvent){
        System.out.println(startupAddedUserEvent);
        manageTeamMemberEvent.saveTeamMemberEvent(new TeamMemberEvent(startupAddedUserEvent));
    }

    @KafkaListener(
            containerFactory = "startupRemovedUserEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.teamMemberEvents.application.kafka.TeamMemberConsumer.topics.startup.removed_user}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncStartupRemovedUser(StartupRemovedUserEvent startupRemovedUserEvent){
        System.out.println(startupRemovedUserEvent);
        manageTeamMemberEvent.saveTeamMemberEvent(new TeamMemberEvent(startupRemovedUserEvent));
    }
}
