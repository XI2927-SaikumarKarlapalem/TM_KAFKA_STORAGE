package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="vault.core_api.v1.calendar.calendar.events")
public class calendar_events {

	
	@Id
	String event_id;
	String timestamp;
	String change_id;
	String id;
	String calendar_period_descriptor_id;
	String is_active;
	String create_timestamp;
	String display_name;
	String description;
	
	
	
	

	
}