package com.kafka.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka.entity.payment_order;

public interface payment_order_repo extends JpaRepository<payment_order,Integer> {

}
