package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.customer;

public interface CustomerRepository extends JpaRepository<customer,Integer> {

	boolean existsByIdIgnoreCase(String id);

}
