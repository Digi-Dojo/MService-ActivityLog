package com.startupsdigidojo.activitylog.noteEvents.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteEventRepository extends JpaRepository<NoteEvent,Long> {
}
