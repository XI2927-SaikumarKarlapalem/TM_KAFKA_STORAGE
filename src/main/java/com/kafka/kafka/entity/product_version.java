package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.api.v1.products.product_version.created")
public class product_version {
	@Id
	String id;
    String display_name;
    String create_timestamp;
    String is_current;
    String description;
    String summary;
    String product_id;
    String tside;
    String contract_module_details;
    String entity_id;
    	String event_id;
       String capture_timestamp;
        String context;

}
