package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.account_status_updated;

public interface account_status_updated_Repo  extends JpaRepository<account_status_updated,Integer>{

	boolean existsByIdIgnoreCase(String id);

}
