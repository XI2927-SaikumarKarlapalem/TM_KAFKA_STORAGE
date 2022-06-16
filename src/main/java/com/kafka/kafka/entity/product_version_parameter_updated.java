package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.api.v1.products.product_version.parameter.updated")
public class product_version_parameter_updated {
	
	@Id
	String id;
	 String name;
	    String display_name;
	    String description;
	    String value;
	    String default_value;
	    String effective_timestamp;
	    String level;
	    String update_permission;
	    String derived;
	    String event_id;
	    String capture_timestamp;

}
