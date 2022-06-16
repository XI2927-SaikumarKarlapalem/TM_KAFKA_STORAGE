package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "vault.api.v1.audit_logs.audit_log.created")
public class audit_log {

	@Id
	String id;
	String api_type;
	String endpoint_name;
	String rest_endpoint_name;
	String create_timestamp;
	String request_initiator_id;
	String on_behalf_of_customer_id;
	String on_behalf_of_employee_id;
	String request_parameters;
	String response_status;
	String response_payload;
	String create_request_id;
	String vault_object_type;
	String vault_object_ids;
	String group_id;

	String event_id;
	String capture_timestamp;

}
