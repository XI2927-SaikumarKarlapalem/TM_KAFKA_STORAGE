package com.kafka.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "vault.core_api.v1.payment_orders.payment_order.events")
public class payment_order {
	@Id
	String event_id;
	String timestamp;
	String change_id;

	String id;
	String create_request_id;
	String client_id;
	String client_order_id;
	String debtor_account_id;
	String routing_info_type;
	String identification;

	String name;

	String denomination;
	String reference;
	String type;

	String payment_date;
	String payment_amount;
	String current_status;
	String create_timestamp;
	String update_timestamp;
	String calendar_id;
	String event_name;
	String calendar_mode;
	String event_duration;

}
