package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="vault.core_api.v1.customers.customer_address.events")
@Data
public class customer_addresses {
	@Id
	  String id;
      String house_name;
      String street_number;
      String street;
      String local_municipality;
      String city;
      String postal_area;
      String governing_district;
      String country;
      String address_type;
      String start_timestamp;
      String end_timestamp;
      String customer_id;
    	  String change_id;
    	  String event_id;
    	  String timestamp;

}
