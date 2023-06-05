package com.startupsdigidojo.activitylog.placeEvents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagePlaceEvent {
    private final PlaceEventRepository placeEventRepository;

    @Autowired
    public ManagePlaceEvent(PlaceEventRepository placeEventRepository) {
        this.placeEventRepository = placeEventRepository;
    }

    public void savePlaceEvent(PlaceEvent placeEvent){
        placeEventRepository.save(placeEvent);
    }
}
