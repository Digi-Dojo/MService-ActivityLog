package com.startupsdigidojo.activitylog.teamMemberEvents.application.kafka;

import com.startupsdigidojo.activitylog.teamMemberEvents.application.ManageTeamMemberEvent;
import com.startupsdigidojo.activitylog.teamMemberEvents.application.TeamMemberEvent;
import com.startupsdigidojo.activitylog.teamMemberEvents.application.dto.NewTeamMemberEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeamMemberConsumer {
    private final ManageTeamMemberEvent manageTeamMemberEvent;

    @KafkaListener(
            containerFactory = "newTeamMemberEventKafkaListenerContainerFactory",
            topics = "${com.startupsdigidojo.activitylog.teamMemberEvents.application.kafka.TeamMemberConsumer.topics.startup.added_user}",
            groupId = "${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}"
    )
    public void syncNewTeamMember(NewTeamMemberEvent newTeamMemberEvent){
        System.out.println(newTeamMemberEvent);
        manageTeamMemberEvent.saveTeamMemberEvent(new TeamMemberEvent(newTeamMemberEvent));
    }
}
