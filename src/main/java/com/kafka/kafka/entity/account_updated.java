package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "vault.core_api.v1.accounts.account_update.events")
public class account_updated {

	@Id
	String event_id;
	String timestamp;
	String change_id;
	String id;
	String account_id;
	String status;
	String activation_update;
	String create_timestamp;
	String last_status_update_timestamp;
	String account_update_batch_id;
	String job_id;
	String failure_reason;

}
