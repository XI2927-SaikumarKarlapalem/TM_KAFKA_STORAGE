package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.core_api.v1.balances.balance.events")
public class Balance_event {
	@Id
	String id;
    String account_id;
    String account_address;
    String phase;
    String asset;
    String denomination;
    String posting_instruction_batch_id;
    String update_posting_instruction_batch_id;
    String value_time;
    String amount;
    String total_debit;
    String total_credit;
    String change_id;
    String event_id;
    String timestamp;
}
