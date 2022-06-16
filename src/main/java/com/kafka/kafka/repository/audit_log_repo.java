package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.audit_log;

public interface audit_log_repo extends JpaRepository<audit_log,Integer> {

}
