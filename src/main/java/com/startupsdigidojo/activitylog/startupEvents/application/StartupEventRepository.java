package com.startupsdigidojo.activitylog.startupEvents.application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartupEventRepository extends JpaRepository<StartupEvent, Long> {

}
