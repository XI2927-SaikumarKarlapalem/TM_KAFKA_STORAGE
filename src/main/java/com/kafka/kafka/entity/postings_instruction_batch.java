package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.api.v1.postings.posting_instruction_batch.created")
public class postings_instruction_batch {
	
	
	
    @Id
	String id;
	String event_id;
	String create_request_id;
	String client_id;
	String client_batch_id;
	//String posting_id;
	String  account_id;
	String client_transaction_id;
	String amount;
	String denomination;
	String internal_account_id;
	String advice;
	String target_account_id;
	//String pics;
	String category;
	//String scheme_name;
	String settlement_date;
	String domain;
	String family;
	String subfamily;
	String value_timestamp;
	String status;
	//String error;
	String insertion_timestamp;
	String dryrun;
	
	String capture_timestamp;
	String error_message;
	String error_type;
	String authorization_type;
	String account_holder_name;
	String reason;
	String contract_violations_type;
	String contract_violation_account_id;
	String requires_review;
	String customer_id;
	String payment_device_id;
	String restriction_violation_account_id;
	String restriction_set_id;
	//String restriction_all;
	String type;
	String phase;
	String asset;
	String account_address;
	String credit;
	String scheme_name;
	String posting_id;
	
	

String account_violation_account_id;

String payment_device_token;
String account_violation_type;

}
