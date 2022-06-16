package com.kafka.kafka.listner;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kafka.kafka.entity.Balance_event;

import javax.persistence.Id;
import com.kafka.kafka.entity.account_updated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.kafka.kafka.entity.customer;
import com.kafka.kafka.entity.customer_addresses;
import com.kafka.kafka.entity.account_created;
import com.kafka.kafka.repository.Account_Created_Repository;
import com.kafka.kafka.repository.Blance_Repository;
import com.kafka.kafka.repository.CustomerRepository;
import com.kafka.kafka.repository.account_status_updated_Repo;
import com.kafka.kafka.repository.account_updated_repository;
import com.kafka.kafka.repository.audit_log_repo;
import com.kafka.kafka.repository.calendar_repo;
import com.kafka.kafka.repository.customer_address_repository;
import com.kafka.kafka.repository.customer_updated_Repository;
import com.kafka.kafka.repository.payment_order_repo;
import com.kafka.kafka.repository.postings_instructions_batch_repo;
import com.kafka.kafka.repository.product_version_Repo;
import com.kafka.kafka.repository.product_version_parameter_updated_Repo;
import com.kafka.kafka.entity.customer_updated;
import com.kafka.kafka.entity.payment_order;
import com.kafka.kafka.entity.postings_instruction_batch;
import com.kafka.kafka.entity.account_status_updated;
import com.kafka.kafka.entity.calendar_events;
import com.kafka.kafka.entity.product_version;
import com.kafka.kafka.entity.product_version_parameter_updated;
import com.kafka.kafka.entity.audit_log;

@Service
public class KafakListner {

	@Autowired
	CustomerRepository crp;

	@Autowired
	Account_Created_Repository acp;

	@Autowired
	Blance_Repository br;

	@Autowired
	customer_updated_Repository cur;

	@Autowired
	calendar_repo cro;

	@Autowired
	customer_address_repository car;

	@Autowired
	account_status_updated_Repo asur;

	@Autowired
	product_version_Repo pvr;

	@Autowired
	product_version_parameter_updated_Repo pvpur;

	@Autowired
	postings_instructions_batch_repo pibp;

	@Autowired
	payment_order_repo por;

	@Autowired
	account_updated_repository aur;

	@Autowired
	audit_log_repo alp;

	@KafkaListener(topics = {
			"vault.api.v1.customers.customer.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void customer(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		try {
			String id = k.findPath("id").asText();
			String status = k.findPath("status").asText();
			String identifier_type = k.findPath("identifier_type").asText();
			String identifier = k.findPath("identifier").asText();
			String title = k.findPath("title").asText();
			String first_name = k.findPath("first_name").asText();
			String middle_name = k.findPath("middle_name").asText();
			String last_name = k.findPath("last_name").asText();
			String dob = k.findPath("dob").asText();
			String gender = k.findPath("gender").asText();
			String nationality = k.findPath("nationality").asText();
			String email_address = k.findPath("email_address").asText();
			String mobile_phone_number = k.findPath("mobile_phone_number").asText();
			String home_phone_number = k.findPath("home_phone_number").asText();
			String business_phone_number = k.findPath("business_phone_number").asText();
			String contact_method = k.findPath("contact_method").asText();
			String country_of_residence = k.findPath("country_of_residence").asText();
			String country_of_taxation = k.findPath("country_of_taxation").asText();
			String accessibility = k.findPath("accessibility").asText();
			String external_customer_id = k.findPath("external_customer_id").asText();
			String additional_details = k.findPath("additional_details").asText();
			String event_id = k.findPath("event_id").asText();
			String capture_timestamp = k.findPath("capture_timestamp").asText();

			customer c = new customer();
			c.setAccessibility(accessibility);
			c.setAdditional_details(additional_details);
			c.setCapture_timestamp(capture_timestamp);
			c.setAccessibility(external_customer_id);
			c.setContact_method(contact_method);
			c.setCountry_of_residence(country_of_residence);
			c.setCountry_of_taxation(country_of_taxation);
			c.setEmail_address(email_address);
			c.setEvent_id(event_id);
			c.setExternal_customer_id(external_customer_id);
			c.setFirst_name(first_name);
			c.setGender(gender);
			c.setHome_phone_number(home_phone_number);
			c.setId(event_id);
			c.setIdentifier(identifier);
			c.setIdentifier_type(identifier_type);
			c.setLast_name(last_name);
			c.setMiddle_name(middle_name);
			c.setMobile_phone_number(mobile_phone_number);
			c.setStatus(status);
			c.setDob(dob);
			c.setId(id);
			c.setBusiness_phone_number(business_phone_number);
			c.setTitle(title);
			c.setNationality(nationality);

			boolean isExists = crp.existsByIdIgnoreCase(c.getId());
			if (!isExists) {
				crp.save(c);

			}

		} catch (NullPointerException e) {
			System.out.println("its okay");

		} finally {

		}

	}

	@KafkaListener(topics = {
			"vault.api.v1.accounts.account.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void account_createdd(String message)
			throws JsonMappingException, JsonProcessingException, NullPointerException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();

		JsonNode a = ob.readTree(message);
		try {
			String id = a.findPath("id").asText();
			String name = a.findPath("name").asText();
			String product_id = a.findPath("product_id").asText();
			String product_version_id = a.findPath("product_version_id").asText();
			List<String> permitted_denominations = a.findValuesAsText("permitted_denominations");

			String status = a.findPath("status").asText();
			String opening_timestamp = a.findPath("opening_timestamp").asText();
			String closing_timestamp = a.findPath("closing_timestamp").asText();
			List<String> stakeholder_ids = a.findValue("stakeholder_ids").findValuesAsText("stakeholder_ids");
			System.out.println(stakeholder_ids + "account_status_updated............................");
			String account_closure_period = a.findPath("account_closure_period").asText();
			String auto_rollover_type = a.findPath("auto_rollover_type").asText();
			String cool_off_period = a.findPath("cool_off_period").asText();
			String deposit_period = a.findPath("deposit_period").asText();
			String fee_free_percentage_limit = a.findPath("fee_free_percentage_limit").asText();
			String grace_period = a.findPath("grace_period").asText();
			String gross_interest_rate = a.findPath("gross_interest_rate").asText();
			String interest_application_day = a.findPath("interest_application_day").asText();
			String interest_application_frequency = a.findPath("interest_application_frequency").asText();
			String partial_principal_amount = a.findPath("partial_principal_amount").asText();
			String period_end_hour = a.findPath("period_end_hour").asText();
			String rollover_account_closure_period = a.findPath("rollover_account_closure_period").asText();
			String rollover_grace_period = a.findPath("rollover_grace_period").asText();
			String rollover_gross_interest_rate = a.findPath("rollover_gross_interest_rate").asText();
			String rollover_interest_application_day = a.findPath("rollover_interest_application_day").asText();
			String rollover_interest_application_frequency = a.findPath("rollover_interest_application_frequency")
					.asText();
			String rollover_period_end_hour = a.findPath("rollover_period_end_hour").asText();
			String rollover_term = a.findPath("rollover_term").asText();
			String rollover_term_unit = a.findPath("rollover_term_unit").asText();
			String term = a.findPath("term").asText();
			String term_unit = a.findPath("term_unit").asText();
			String withdrawal_fee = a.findPath("withdrawal_fee").asText();
			String withdrawal_percentage_fee = a.findPath("withdrawal_percentage_fee").asText();

			String derived_instance_param_vals = a.findPath("derived_instance_param_vals").asText();
			String details = a.findPath("details").asText();
			String tside = a.findPath("tside").asText();

			String event_id = a.findPath("event_id").asText();
			String capture_timestamp = a.findPath("capture_timestamp").asText();

			account_created acc = new account_created();

			acc.setAccount_closure_period(account_closure_period);

			acc.setAuto_rollover_type(auto_rollover_type);
			acc.setCapture_timestamp(capture_timestamp);
			acc.setClosing_timestamp(closing_timestamp);
			acc.setCool_off_period(cool_off_period);
			acc.setDeposit_period(deposit_period);
			acc.setDetails(details);
			acc.setEvent_id(event_id);
			acc.setFee_free_percentage_limit(fee_free_percentage_limit);
			acc.setGrace_period(grace_period);
			acc.setGross_interest_rate(gross_interest_rate);
			acc.setId(id);
			acc.setInterest_application_day(interest_application_day);
			acc.setInterest_application_frequency(interest_application_frequency);
			acc.setName(name);
			acc.setOpening_timestamp(opening_timestamp);
			acc.setPartial_principal_amount(partial_principal_amount);
			acc.setPeriod_end_hour(period_end_hour);
			acc.setPermitted_denominations(permitted_denominations);
			acc.setProduct_id(product_id);
			acc.setProduct_version_id(product_version_id);
			acc.setRollover_account_closure_period(rollover_account_closure_period);
			acc.setRollover_grace_period(rollover_grace_period);
			acc.setRollover_gross_interest_rate(rollover_gross_interest_rate);
			acc.setRollover_interest_application_day(rollover_interest_application_day);
			acc.setRollover_interest_application_frequency(rollover_interest_application_frequency);
			acc.setRollover_period_end_hour(rollover_period_end_hour);
			acc.setRollover_term(rollover_term);
			acc.setRollover_term_unit(rollover_term_unit);
			acc.setStakeholder_ids(stakeholder_ids);
			acc.setStatus(status);
			acc.setTerm(term);
			acc.setTerm_unit(term_unit);
			acc.setTside(tside);
			acc.setWithdrawal_fee(withdrawal_fee);
			acc.setWithdrawal_percentage_fee(withdrawal_percentage_fee);
			acc.setDerived_instance_param_vals(derived_instance_param_vals);

			boolean isExists = acp.existsByIdIgnoreCase(acc.getId());
			if (!isExists) {
				acp.save(acc);

			}
		} catch (NullPointerException e) {
			System.out.println("ok i know its NullPointerException");
		}

		finally {
			System.out.println("final");
		}

	}

	@KafkaListener(topics = {
			"vault.core_api.v1.balances.balance.events" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void Balance_event(String message) throws JsonMappingException, JsonProcessingException, NullPointerException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();

		JsonNode c = ob.readTree(message);
		String id = c.findPath("id").asText();
		String account_id = c.findPath("account_id").asText();
		String account_address = c.findPath("account_address").asText();
		String phase = c.findPath("phase").asText();
		String asset = c.findPath("asset").asText();
		String denomination = c.findPath("denomination").asText();
		String posting_instruction_batch_id = c.findPath("posting_instruction_batch_id").asText();
		String update_posting_instruction_batch_id = c.findPath("update_posting_instruction_batch_id").asText();
		String value_time = c.findPath("value_time").asText();
		String amount = c.findPath("amount").asText();
		String total_debit = c.findPath("total_debit").asText();
		String total_credit = c.findPath("total_credit").asText();
		String change_id = c.findPath("change_id").asText();

		String event_id = c.findPath("event_id").asText();
		String timestamp = c.findPath("time_stamp").asText();

		Balance_event bc = new Balance_event();
		bc.setAccount_address(account_address);
		bc.setAccount_id(account_id);
		bc.setAmount(amount);
		bc.setAsset(asset);
		bc.setChange_id(change_id);
		bc.setDenomination(denomination);
		bc.setEvent_id(event_id);
		bc.setId(event_id);
		bc.setPhase(phase);
		bc.setPosting_instruction_batch_id(update_posting_instruction_batch_id);
		bc.setTimestamp(timestamp);
		bc.setTotal_credit(total_credit);
		bc.setTotal_debit(total_debit);
		bc.setUpdate_posting_instruction_batch_id(update_posting_instruction_batch_id);
		bc.setValue_time(value_time);
		bc.setId(id);
		bc.setPosting_instruction_batch_id(posting_instruction_batch_id);

		boolean isExists = br.existsByIdIgnoreCase(bc.getId());
		if (!isExists) {
			br.save(bc);

		}

	}

	@KafkaListener(topics = {
			"vault.api.v1.customers.customer.customer_details.updated" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void customer_updated(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		try {
			String id = k.findPath("id").asText();
			String status = k.findPath("status").asText();

			String title = k.findPath("title").asText();
			String first_name = k.findPath("first_name").asText();
			String middle_name = k.findPath("middle_name").asText();
			String last_name = k.findPath("last_name").asText();
			String dob = k.findPath("dob").asText();
			String gender = k.findPath("gender").asText();
			String nationality = k.findPath("nationality").asText();
			String email_address = k.findPath("email_address").asText();
			String mobile_phone_number = k.findPath("mobile_phone_number").asText();
			String home_phone_number = k.findPath("home_phone_number").asText();
			String business_phone_number = k.findPath("business_phone_number").asText();
			String contact_method = k.findPath("contact_method").asText();
			String country_of_residence = k.findPath("country_of_residence").asText();
			String country_of_taxation = k.findPath("country_of_taxation").asText();
			String accessibility = k.findPath("accessibility").asText();
			String external_customer_id = k.findPath("external_customer_id").asText();

			String event_id = k.findPath("event_id").asText();
			String capture_timestamp = k.findPath("capture_timestamp").asText();

			customer_updated c = new customer_updated();
			c.setAccessibility(accessibility);

			c.setCapture_timestamp(capture_timestamp);
			c.setAccessibility(external_customer_id);
			c.setContact_method(contact_method);
			c.setCountry_of_residence(country_of_residence);
			c.setCountry_of_taxation(country_of_taxation);
			c.setEmail_address(email_address);
			c.setEvent_id(event_id);
			c.setExternal_customer_id(external_customer_id);
			c.setFirst_name(first_name);
			c.setGender(gender);
			c.setHome_phone_number(home_phone_number);
			c.setId(event_id);

			c.setLast_name(last_name);
			c.setMiddle_name(middle_name);
			c.setMobile_phone_number(mobile_phone_number);
			c.setStatus(status);
			c.setDob(dob);
			c.setId(id);
			c.setBusiness_phone_number(business_phone_number);
			c.setTitle(title);
			c.setNationality(nationality);

			boolean isExists = cur.existsByIdIgnoreCase(c.getId());
			if (!isExists) {
				cur.save(c);

			}
		} catch (NullPointerException e) {
		} finally {
		}

	}

	@KafkaListener(topics = {
			"vault.core_api.v1.customers.customer_address.events" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void customer_address(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		try {
			String id = k.findPath("id").asText();
			String house_name = k.findPath("house_name").asText();
			String street_number = k.findPath("street_number").asText();
			String street = k.findPath("street").asText();
			String local_municipality = k.findPath("local_municipality").asText();
			String city = k.findPath("city").asText();
			String postal_area = k.findPath("postal_area").asText();
			String governing_district = k.findPath("governing_district").asText();
			String country = k.findPath("country").asText();
			String address_type = k.findPath("address_type").asText();
			String start_timestamp = k.findPath("start_timestamp").asText();
			String end_timestamp = k.findPath("end_timestamp").asText();
			String customer_id = k.findPath("customer_id").asText();
			String change_id = k.findPath("change_id").asText();
			String event_id = k.findPath("event_id").asText();
			String timestamp = k.findPath("timestamp").asText();

			customer_addresses ca = new customer_addresses();
			ca.setAddress_type(address_type);
			ca.setChange_id(change_id);
			ca.setCity(city);
			ca.setCountry(country);
			ca.setCustomer_id(customer_id);
			ca.setEnd_timestamp(end_timestamp);
			ca.setEnd_timestamp(end_timestamp);
			ca.setEvent_id(event_id);
			ca.setGoverning_district(governing_district);
			ca.setHouse_name(house_name);
			ca.setId(id);
			ca.setLocal_municipality(local_municipality);
			ca.setPostal_area(postal_area);
			ca.setStart_timestamp(start_timestamp);
			ca.setStreet(street);
			ca.setStreet_number(street_number);
			ca.setTimestamp(timestamp);

			boolean isExists = car.existsByIdIgnoreCase(ca.getId());
			if (!isExists) {
				car.save(ca);

			}
		} catch (NullPointerException e) {

		} finally {
		}
	}

	@KafkaListener(topics = {
			"vault.api.v1.accounts.account.status.updated" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void account_status_updated(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		try {
			String id = k.findPath("id").asText();
			String status = k.findPath("status").asText();
			String event_id = k.findPath("event_id").asText();
			String capture_timestamp = k.findPath("capture_timestamp").asText();

			account_status_updated asu = new account_status_updated();
			asu.setCapture_timestamp(capture_timestamp);
			asu.setEvent_id(event_id);
			asu.setStatus(status);
			asu.setId(id);

			boolean isExists = asur.existsByIdIgnoreCase(asu.getId());
			if (!isExists) {
				asur.save(asu);
			}

		} catch (NullPointerException e) {

		} finally {
		}

	}

	@KafkaListener(topics = {
			"vault.api.v1.products.product_version.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void product_version(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		try {
			String id = k.findPath("id").asText();
			String display_name = k.findPath("display_name").asText();
			String create_timestamp = k.findPath("create_timestamp").asText();
			String is_current = k.findPath("is_current").asText();
			String description = k.findPath("description").asText();
			String summary = k.findPath("summary").asText();
			String product_id = k.findPath("product_id").asText();
			String tside = k.findPath("tside").asText();
			String contract_module_details = k.findPath("contract_module_details").asText();
			String entity_id = k.findPath("entity_id").asText();
			String event_id = k.findPath("event_id").asText();
			String capture_timestamp = k.findPath("capture_timestamp").asText();
			String context = k.findPath("context").asText();

			product_version pv = new product_version();
			pv.setCapture_timestamp(capture_timestamp);
			pv.setContext(context);
			pv.setContract_module_details(contract_module_details);
			pv.setDescription(description);
			pv.setDisplay_name(display_name);
			pv.setEntity_id(entity_id);
			pv.setId(id);
			pv.setIs_current(is_current);
			pv.setEvent_id(event_id);
			pv.setCreate_timestamp(create_timestamp);
			pv.setSummary(summary);
			pv.setProduct_id(product_id);
			pv.setTside(tside);
			boolean isExists = pvr.existsByIdIgnoreCase(pv.getId());
			if (!isExists) {
				pvr.save(pv);

			}
		} catch (NullPointerException e) {

		} finally {
		}

	}

	@KafkaListener(topics = {
			"vault.api.v1.products.product_version.parameter.updated" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void product_version_parameter_update(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		try {
			String id = k.findPath("id").asText();
			String name = k.findPath("name").asText();
			String display_name = k.findPath("display_name").asText();
			String description = k.findPath("description").asText();
			String value = k.findPath("value").asText();
			String default_value = k.findPath("default_value").asText();
			String effective_timestamp = k.findPath("effective_timestamp").asText();
			String level = k.findPath("level").asText();
			String update_permission = k.findPath("update_permission").asText();
			String derived = k.findPath("derived").asText();
			String event_id = k.findPath("event_id").asText();
			String capture_timestamp = k.findPath("capture_timestamp").asText();

			product_version_parameter_updated pvpd = new product_version_parameter_updated();

			pvpd.setId(id);
			pvpd.setName(name);
			pvpd.setDisplay_name(display_name);
			pvpd.setDescription(description);
			pvpd.setEffective_timestamp(effective_timestamp);
			pvpd.setValue(value);
			pvpd.setDefault_value(default_value);
			pvpd.setCapture_timestamp(capture_timestamp);
			pvpd.setDerived(derived);
			pvpd.setUpdate_permission(update_permission);
			pvpd.setLevel(level);
			pvpd.setEvent_id(event_id);

			boolean isExists = pvpur.existsByIdIgnoreCase(pvpd.getId());
			if (!isExists) {
				pvpur.save(pvpd);
			}
		} catch (NullPointerException e) {

		} finally {
		}

	}

	@KafkaListener(topics = {
			"vault.api.v1.postings.posting_instruction_batch.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void posting_instructions_batch(String message) throws IOException, NullPointerException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();

		JsonNode c = ob.readTree(message);
		String id = c.findPath("id").asText();
		String create_request_id = c.findPath("create_request_id").asText();
		String client_batch_id = c.findPath("client_batch_id").asText();
		String client_id = c.findPath("client_id").asText();
		JsonNode posting_instructions = c.findPath("posting_instructions");
		JsonNode posting_violations = c.findPath("posting_violations");
		JsonNode account_violations = c.findPath("account_violations");
		JsonNode restriction_violations = c.findPath("restriction_violations");
		JsonNode contract_violations = c.findPath("contract_violations");
		JsonNode transaction_code = c.findPath("transaction_code");
		JsonNode committed_postings = c.findPath("committed_postings");
		JsonNode batch_details = c.findPath("batch_details");
		JsonNode instruction_details = c.findPath("instruction_details");
		JsonNode error = c.findPath("error");

		String account_violation_account_id = account_violations.findPath("account_id").asText();

		String payment_device_token = account_violations.findPath("payment_device_token").asText();
		String account_violation_type = account_violations.findPath("type").asText();

		String posting_id = posting_instructions.findPath("id").asText();
		String client_transaction_id = posting_instructions.findPath("client_transaction_id").asText();
		String scheme_name = instruction_details.findPath("scheme_name").asText();
		String settlement_date = c.findPath("settlement_date").asText();
		String category = c.findPath("category").asText();
		String credit = committed_postings.findPath("credit").asText();
		String amount = committed_postings.findPath("amount").asText();
		String account_id = committed_postings.findPath("account_id").asText();
		String denomination = committed_postings.findPath("denomination").asText();
		String account_address = committed_postings.findPath("account_address").asText();
		String asset = committed_postings.findPath("asset").asText();
		String phase = committed_postings.findPath("phase").asText();
		String type = posting_violations.findPath("type").asText();
		String restriction_set_id = restriction_violations.findPath("restriction_set_id").asText();
		String restriction_violation_account_id = restriction_violations.findPath("account_id").asText();
		String payment_device_id = restriction_violations.findPath("payment_device_id").asText();
		String customer_id = restriction_violations.findPath("customer_id").asText();
		String requires_review = restriction_violations.findPath("requires_review").asText();
		String contract_violation_account_id = contract_violations.findPath("account_id").asText();
		String contract_violations_type = contract_violations.findPath("type").asText();
		String reason = contract_violations.findPath("reason").asText();
		String domain = transaction_code.findPath("domain").asText();
		String family = transaction_code.findPath("family").asText();
		String subfamily = transaction_code.findPath("subfamily").asText();
		String internal_account_id = c.findPath("internal_account_id").asText();
		String advice = c.findPath("advice").asText();
		String target_account_id = c.findPath("target_account_id").asText();
		String account_holder_name = batch_details.findPath("account_holder_name").asText();
		String authorization_type = batch_details.findPath("transaction_type").asText();
		String value_timestamp = c.findPath("value_timestamp").asText();
		String status = c.findPath("status").asText();
		String error_type = error.findPath("type").asText();
		String error_message = error.findPath("message").asText();
		String insertion_timestamp = c.findPath("insertion_timestamp").asText();
		String dry_run = c.findPath("dry_run").asText();
		String event_id = c.findPath("event_id").asText();
		String capture_timestamp = c.findPath("capture_timestamp").asText();

		postings_instruction_batch pib = new postings_instruction_batch();

		pib.setError_message(error_message);
		pib.setAccount_violation_account_id(account_violation_account_id);
		pib.setAccount_violation_type(account_violation_type);
		pib.setPayment_device_token(payment_device_token);
		pib.setAccount_id(account_id);
		pib.setAdvice(advice);
		pib.setAmount(amount);
		pib.setCapture_timestamp(capture_timestamp);
		pib.setCategory(category);
		pib.getClient_batch_id();
		pib.setClient_transaction_id(client_transaction_id);
		pib.setCreate_request_id(create_request_id);
		pib.setDenomination(denomination);
		pib.setDomain(domain);
		pib.setDryrun(dry_run);
		pib.setEvent_id(event_id);
		pib.setFamily(family);
		pib.setId(id);
		pib.setInsertion_timestamp(insertion_timestamp);
		pib.setInternal_account_id(internal_account_id);
		pib.setScheme_name(scheme_name);
		pib.setClient_batch_id(client_batch_id);
		pib.setClient_id(client_id);
		pib.setError_type(type);
		pib.setError_message(error_message);
		pib.setStatus(status);
		pib.setValue_timestamp(value_timestamp);
		pib.setSubfamily(subfamily);
		pib.setTarget_account_id(target_account_id);
		pib.setSettlement_date(settlement_date);
		pib.setPosting_id(posting_id);
		pib.setScheme_name(scheme_name);
		pib.setError_type(error_type);
		pib.setAuthorization_type(authorization_type);
		pib.setAccount_holder_name(account_holder_name);
		pib.setReason(reason);
		pib.setContract_violations_type(contract_violations_type);
		pib.setContract_violation_account_id(contract_violation_account_id);
		pib.setRequires_review(requires_review);
		pib.setCustomer_id(customer_id);
		pib.setPayment_device_id(payment_device_id);
		pib.setRestriction_violation_account_id(restriction_violation_account_id);
		pib.setRestriction_set_id(restriction_set_id);
		pib.setType(type);
		pib.setPhase(phase);
		pib.setAccount_address(account_address);
		pib.setAsset(asset);
		pib.setCredit(credit);

		pibp.save(pib);

	}

	@KafkaListener(topics = {
			"vault.core_api.v1.calendar.calendar.events" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void calendar_events(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);

		String event_id;
		String timestamp;
		String change_id;
		String id;
		String calendar_period_descriptor_id;
		String is_active;
		String create_timestamp;
		String display_name;
		String description;
		event_id = k.findPath("event_id").asText();
		timestamp = k.findPath("timestamp").asText();
		change_id = k.findPath("change_id").asText();
		id = k.findPath("id").asText();
		calendar_period_descriptor_id = k.findPath("calendar_period_descriptor_id").asText();
		is_active = k.findPath("is_active").asText();
		create_timestamp = k.findPath("create_timestamp").asText();
		display_name = k.findPath("display_name").asText();
		description = k.findPath("description").asText();

		calendar_events ce = new calendar_events();
		ce.setCalendar_period_descriptor_id(calendar_period_descriptor_id);
		ce.setChange_id(change_id);
		ce.setCreate_timestamp(create_timestamp);
		ce.setDescription(description);
		ce.setDisplay_name(display_name);
		ce.setEvent_id(event_id);
		ce.setId(id);
		ce.setIs_active(is_active);
		ce.setTimestamp(timestamp);
		ce.setDescription(description);
		cro.save(ce);

	}

	@KafkaListener(topics = {
			"vault.core_api.v1.payment_orders.payment_order.events" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void payment_order_events(String message) throws JsonMappingException, JsonProcessingException

	{

		System.out.println(message);
		ObjectMapper ob = new ObjectMapper();
		JsonNode k = ob.readTree(message);
		String event_id = k.findPath("event_id").asText();
		String timestamp = k.findPath("timestamp").asText();
		String change_id = k.findPath("change_id").asText();

		String id = k.findPath("id").asText();
		String create_request_id = k.findPath("create_request_id").asText();
		String client_id = k.findPath("client_id").asText();
		String client_order_id = k.findPath("client_order_id").asText();
		String debtor_account_id = k.findPath("debtor_account_id").asText();
		String routing_info_type = k.findPath("routing_info_type").asText();
		String identification = k.findPath("identification").asText();

		String name = k.findPath("name").asText();

		String denomination = k.findPath("denomination").asText();
		String reference = k.findPath("reference").asText();
		String type = k.findPath("type").asText();

		String payment_date = k.findPath("payment_date").asText();
		String payment_amount = k.findPath("payment_amount").asText();
		String current_status = k.findPath("current_status").asText();
		String create_timestamp = k.findPath("create_timestamp").asText();
		String update_timestamp = k.findPath("update_timestamp").asText();
		String calendar_id = k.findPath("calendar_id").asText();
		String event_name = k.findPath("event_name").asText();
		String calendar_mode = k.findPath("calendar_mode").asText();
		String event_duration = k.findPath("event_duration").asText();

		payment_order po = new payment_order();
		po.setCalendar_id(calendar_id);
		po.setCalendar_mode(calendar_mode);
		po.setChange_id(change_id);
		po.setClient_id(client_id);
		po.setClient_order_id(client_order_id);
		po.setCreate_request_id(create_request_id);
		po.setCreate_timestamp(create_timestamp);
		po.setCurrent_status(current_status);
		po.setDebtor_account_id(debtor_account_id);
		po.setDenomination(denomination);
		po.setEvent_duration(event_duration);
		po.setEvent_id(event_id);
		po.setEvent_name(event_name);
		po.setPayment_amount(payment_amount);
		po.setUpdate_timestamp(update_timestamp);
		po.setPayment_date(payment_date);
		po.setReference(reference);
		po.setType(type);
		po.setId(id);
		po.setTimestamp(timestamp);
		po.setName(name);
		po.setRouting_info_type(routing_info_type);
		po.setIdentification(identification);

		por.save(po);

	}

//	@KafkaListener(topics = {
//			"vault.api.v1.audit_logs.audit_log.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
//	public void audit_log(String message) throws JsonMappingException, JsonProcessingException
//
//	{
//
//		System.out.println(message);
//		ObjectMapper ob = new ObjectMapper();
//		JsonNode k = ob.readTree(message);
//		String id = k.findPath("id").asText();
//		String api_type = k.findPath("api_type").asText();
//		String endpoint_name = k.findPath("endpoint_name").asText();
//		String rest_endpoint_name = k.findPath("rest_endpoint_name").asText();
//		String create_timestamp = k.findPath("create_timestamp").asText();
//		String request_initiator_id = k.findPath("request_iniator_id").asText();
//		String on_behalf_of_customer_id = k.findPath("on_behalf_of_customer_id").asText();
//		String on_behalf_of_employee_id = k.findPath("on_behalf_of_employee_id").asText();
//		String request_parameters = k.findPath("request_parameters").asText();
//		String response_status = k.findPath("response_status").asText();
//		String response_payload = k.findPath("response_payload").asText();
//		String create_request_id = k.findPath("create_request_id").asText();
//		String vault_object_type = k.findPath("vault_object_type").asText();
//		String vault_object_ids = k.findPath("vault_object_ids").asText();
//		String group_id = k.findPath("group_id").asText();
//
//		String event_id = k.findPath("event_id").asText();
//		String capture_timestamp = k.findPath("capture_timestamp").asText();
//
//		audit_log al = new audit_log();
//		al.setApi_type(api_type);
//		al.setCapture_timestamp(capture_timestamp);
//		al.setCreate_request_id(create_request_id);
//		al.setCreate_timestamp(create_timestamp);
//		al.setEndpoint_name(rest_endpoint_name);
//		al.setEvent_id(event_id);
//		al.setGroup_id(group_id);
//		al.setId(id);
//		al.setOn_behalf_of_customer_id(on_behalf_of_customer_id);
//		al.setOn_behalf_of_employee_id(on_behalf_of_employee_id);
//		al.setRequest_initiator_id(request_initiator_id);
//		al.setRequest_parameters(request_parameters);
//		al.setResponse_payload(response_payload);
//		al.setVault_object_ids(vault_object_ids);
//		al.setVault_object_type(vault_object_type);
//		al.setResponse_status(response_status);
//		al.setEndpoint_name(endpoint_name);
//
//		alp.save(al);
//
//	}
}