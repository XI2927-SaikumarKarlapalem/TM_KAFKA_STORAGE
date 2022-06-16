package com.kafka.kafka.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="vault.api.v1.accounts.account.created")
public class account_created {
	
	
	@Id
	    String id;
	    String name;
	    String product_id;
	    String product_version_id;

	    String  permitted_denominations;
	    String status;
	    String opening_timestamp;
	    String closing_timestamp;
	    String stakeholder_ids;
	      String account_closure_period;
	      String auto_rollover_type;
	      String cool_off_period;
	      String deposit_period;
	      String fee_free_percentage_limit;
	      String grace_period;
	      String gross_interest_rate;
	      String interest_application_day;
	      String interest_application_frequency;
	      String partial_principal_amount;
	      String period_end_hour;
	      String rollover_account_closure_period;
	      String rollover_grace_period;
	      String rollover_gross_interest_rate;
	      String rollover_interest_application_day;
	      String rollover_interest_application_frequency;
	      String rollover_period_end_hour;
	      String rollover_term;
	      String rollover_term_unit;
	      String term;
	      String term_unit;
	      String withdrawal_fee;
	      String withdrawal_percentage_fee;
	    
	    String derived_instance_param_vals;
	    String details;
	    String tside;
	   
	 
	    String event_id;
	   String capture_timestamp;
	public List<String> setPermitted_denominations(List<String> permitted_denominations) {
		return permitted_denominations;
		
		
	}
	public List<String> setStakeholder_ids(List<String> stakeholder_ids) {
	return stakeholder_ids;
		
	}

}
