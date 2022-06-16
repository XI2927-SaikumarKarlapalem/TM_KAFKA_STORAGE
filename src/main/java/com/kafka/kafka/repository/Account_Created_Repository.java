package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kafka.kafka.entity.account_created;
public interface Account_Created_Repository extends JpaRepository<account_created,Integer> {

	boolean existsByIdIgnoreCase(String id);

}
