package com.startupsdigidojo.activitylog.startupEvents.application.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewStartupRepository extends JpaRepository<NewStartup, Long> {

}
