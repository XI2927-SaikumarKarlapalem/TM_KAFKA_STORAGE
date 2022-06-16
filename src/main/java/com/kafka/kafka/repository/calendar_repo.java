package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.calendar_events;

public interface calendar_repo extends JpaRepository<calendar_events,Integer>{

}
