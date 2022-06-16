package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.customer_updated;

public interface customer_updated_Repository extends JpaRepository<customer_updated,Integer> {

	boolean existsByIdIgnoreCase(String id);

}
