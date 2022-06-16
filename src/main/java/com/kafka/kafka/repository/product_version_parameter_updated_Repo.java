package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.product_version_parameter_updated;

public interface product_version_parameter_updated_Repo extends JpaRepository<product_version_parameter_updated,Integer> {

	boolean existsByIdIgnoreCase(String id);

}
