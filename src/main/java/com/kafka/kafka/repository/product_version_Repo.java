package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.product_version;

public interface product_version_Repo extends JpaRepository<product_version,Integer> {

	boolean existsByIdIgnoreCase(String id);

}
