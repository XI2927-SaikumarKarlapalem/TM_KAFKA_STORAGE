package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.customer_addresses;

public interface customer_address_repository extends JpaRepository<customer_addresses,Integer> {

	boolean existsByIdIgnoreCase(String id);

}
