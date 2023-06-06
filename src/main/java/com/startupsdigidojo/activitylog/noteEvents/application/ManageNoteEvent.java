package com.startupsdigidojo.activitylog.noteEvents.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageNoteEvent {
    private final NoteEventRepository noteEventRepository;

    @Autowired
    public ManageNoteEvent(NoteEventRepository noteEventRepository) {
        this.noteEventRepository = noteEventRepository;
    }

    public void saveNoteEvent(NoteEvent noteEvent){
        noteEventRepository.save(noteEvent);
    }
}
