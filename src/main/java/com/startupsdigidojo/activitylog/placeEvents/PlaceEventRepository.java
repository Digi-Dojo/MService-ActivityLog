package com.startupsdigidojo.activitylog.placeEvents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceEventRepository extends JpaRepository<PlaceEvent,Long> {
}
