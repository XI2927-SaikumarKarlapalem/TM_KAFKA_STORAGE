package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.api.v1.accounts.account.status.updated")
public class account_status_updated {
	
	@Id
	String id;
	String status;
	String event_id;
	String capture_timestamp;

}
