package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.api.v1.customers.customer.created")
public class customer {

	
	
	
	
@Id
String id;
String status;
String identifier_type;
String identifier;
String title;
String first_name;
String middle_name;
String last_name;
String dob;
String gender;
String nationality;
String email_address;
String mobile_phone_number;
String home_phone_number;
String business_phone_number;
String contact_method;
String country_of_residence;
String country_of_taxation;
String accessibility;
String external_customer_id;
String additional_details;
String event_id;
String capture_timestamp;

}
