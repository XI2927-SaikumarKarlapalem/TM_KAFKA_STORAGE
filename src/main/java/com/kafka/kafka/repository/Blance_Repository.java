package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.Balance_event;

public interface Blance_Repository extends JpaRepository<Balance_event,Integer> {

	boolean existsByIdIgnoreCase(String id);

	

}
