package com.kafka.kafka.listner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class testing {
	

	
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */
	public class AccountViolation{
	    @JsonProperty("account_id") 
	    public String getAccount_id() { 
			 return this.account_id; } 
	    public void setAccount_id(String account_id) { 
			 this.account_id = account_id; } 
	    String account_id;
	    @JsonProperty("payment_device_token") 
	    public String getPayment_device_token() { 
			 return this.payment_device_token; } 
	    public void setPayment_device_token(String payment_device_token) { 
			 this.payment_device_token = payment_device_token; } 
	    String payment_device_token;
	    @JsonProperty("type") 
	    public String getType() { 
			 return this.type; } 
	    public void setType(String type) { 
			 this.type = type; } 
	    String type;
	}

	public class BatchDetails{
	    @JsonProperty("KEY") 
	    public String getKEY() { 
			 return this.kEY; } 
	    public void setKEY(String kEY) { 
			 this.kEY = kEY; } 
	    String kEY;
	}

	public class CommittedPosting{
	    @JsonProperty("credit") 
	    public boolean getCredit() { 
			 return this.credit; } 
	    public void setCredit(boolean credit) { 
			 this.credit = credit; } 
	    boolean credit;
	    @JsonProperty("amount") 
	    public String getAmount() { 
			 return this.amount; } 
	    public void setAmount(String amount) { 
			 this.amount = amount; } 
	    String amount;
	    @JsonProperty("denomination") 
	    public String getDenomination() { 
			 return this.denomination; } 
	    public void setDenomination(String denomination) { 
			 this.denomination = denomination; } 
	    String denomination;
	    @JsonProperty("account_id") 
	    public String getAccount_id() { 
			 return this.account_id; } 
	    public void setAccount_id(String account_id) { 
			 this.account_id = account_id; } 
	    String account_id;
	    @JsonProperty("account_address") 
	    public String getAccount_address() { 
			 return this.account_address; } 
	    public void setAccount_address(String account_address) { 
			 this.account_address = account_address; } 
	    String account_address;
	    @JsonProperty("asset") 
	    public String getAsset() { 
			 return this.asset; } 
	    public void setAsset(String asset) { 
			 this.asset = asset; } 
	    String asset;
	    @JsonProperty("phase") 
	    public String getPhase() { 
			 return this.phase; } 
	    public void setPhase(String phase) { 
			 this.phase = phase; } 
	    String phase;
	}

	public class ContractViolation{
	    @JsonProperty("account_id") 
	    public String getAccount_id() { 
			 return this.account_id; } 
	    public void setAccount_id(String account_id) { 
			 this.account_id = account_id; } 
	    String account_id;
	    @JsonProperty("type") 
	    public String getType() { 
			 return this.type; } 
	    public void setType(String type) { 
			 this.type = type; } 
	    String type;
	    @JsonProperty("reason") 
	    public String getReason() { 
			 return this.reason; } 
	    public void setReason(String reason) { 
			 this.reason = reason; } 
	    String reason;
	}

	public class Error{
	    @JsonProperty("type") 
	    public String getType() { 
			 return this.type; } 
	    public void setType(String type) { 
			 this.type = type; } 
	    String type;
	    @JsonProperty("message") 
	    public String getMessage() { 
			 return this.message; } 
	    public void setMessage(String message) { 
			 this.message = message; } 
	    String message;
	}

	public class InstructionDetails{
	    @JsonProperty("KEY") 
	    public String getKEY() { 
			 return this.kEY; } 
	    public void setKEY(String kEY) { 
			 this.kEY = kEY; } 
	    String kEY;
	}

	public class KEY{
	    @JsonProperty("id") 
	    public String getId() { 
			 return this.id; } 
	    public void setId(String id) { 
			 this.id = id; } 
	    String id;
	    @JsonProperty("create_request_id") 
	    public String getCreate_request_id() { 
			 return this.create_request_id; } 
	    public void setCreate_request_id(String create_request_id) { 
			 this.create_request_id = create_request_id; } 
	    String create_request_id;
	    @JsonProperty("client_id") 
	    public String getClient_id() { 
			 return this.client_id; } 
	    public void setClient_id(String client_id) { 
			 this.client_id = client_id; } 
	    String client_id;
	    @JsonProperty("client_batch_id") 
	    public String getClient_batch_id() { 
			 return this.client_batch_id; } 
	    public void setClient_batch_id(String client_batch_id) { 
			 this.client_batch_id = client_batch_id; } 
	    String client_batch_id;
	    @JsonProperty("posting_instructions") 
	    public ArrayList<PostingInstruction> getPosting_instructions() { 
			 return this.posting_instructions; } 
	    public void setPosting_instructions(ArrayList<PostingInstruction> posting_instructions) { 
			 this.posting_instructions = posting_instructions; } 
	    ArrayList<PostingInstruction> posting_instructions;
	    @JsonProperty("batch_details") 
	    public BatchDetails getBatch_details() { 
			 return this.batch_details; } 
	    public void setBatch_details(BatchDetails batch_details) { 
			 this.batch_details = batch_details; } 
	    BatchDetails batch_details;
	    @JsonProperty("value_timestamp") 
	    public Date getValue_timestamp() { 
			 return this.value_timestamp; } 
	    public void setValue_timestamp(Date value_timestamp) { 
			 this.value_timestamp = value_timestamp; } 
	    Date value_timestamp;
	    @JsonProperty("status") 
	    public String getStatus() { 
			 return this.status; } 
	    public void setStatus(String status) { 
			 this.status = status; } 
	    String status;
	    @JsonProperty("error") 
	    public Error getError() { 
			 return this.error; } 
	    public void setError(Error error) { 
			 this.error = error; } 
	    Error error;
	    @JsonProperty("insertion_timestamp") 
	    public Date getInsertion_timestamp() { 
			 return this.insertion_timestamp; } 
	    public void setInsertion_timestamp(Date insertion_timestamp) { 
			 this.insertion_timestamp = insertion_timestamp; } 
	    Date insertion_timestamp;
	    @JsonProperty("dry_run") 
	    public boolean getDry_run() { 
			 return this.dry_run; } 
	    public void setDry_run(boolean dry_run) { 
			 this.dry_run = dry_run; } 
	    boolean dry_run;
	}

	public class OutboundAuthorisation{
	    @JsonProperty("amount") 
	    public String getAmount() { 
			 return this.amount; } 
	    public void setAmount(String amount) { 
			 this.amount = amount; } 
	    String amount;
	    @JsonProperty("denomination") 
	    public String getDenomination() { 
			 return this.denomination; } 
	    public void setDenomination(String denomination) { 
			 this.denomination = denomination; } 
	    String denomination;
	    @JsonProperty("target_account") 
	    public TargetAccount getTarget_account() { 
			 return this.target_account; } 
	    public void setTarget_account(TargetAccount target_account) { 
			 this.target_account = target_account; } 
	    TargetAccount target_account;
	    @JsonProperty("internal_account_id") 
	    public String getInternal_account_id() { 
			 return this.internal_account_id; } 
	    public void setInternal_account_id(String internal_account_id) { 
			 this.internal_account_id = internal_account_id; } 
	    String internal_account_id;
	    @JsonProperty("advice") 
	    public boolean getAdvice() { 
			 return this.advice; } 
	    public void setAdvice(boolean advice) { 
			 this.advice = advice; } 
	    boolean advice;
	    @JsonProperty("target_account_id") 
	    public String getTarget_account_id() { 
			 return this.target_account_id; } 
	    public void setTarget_account_id(String target_account_id) { 
			 this.target_account_id = target_account_id; } 
	    String target_account_id;
	}

	public class Override{
	    @JsonProperty("restrictions") 
	    public Restrictions getRestrictions() { 
			 return this.restrictions; } 
	    public void setRestrictions(Restrictions restrictions) { 
			 this.restrictions = restrictions; } 
	    Restrictions restrictions;
	}

	public class PostingInstruction{
	    @JsonProperty("id") 
	    public String getId() { 
			 return this.id; } 
	    public void setId(String id) { 
			 this.id = id; } 
	    String id;
	    @JsonProperty("client_transaction_id") 
	    public String getClient_transaction_id() { 
			 return this.client_transaction_id; } 
	    public void setClient_transaction_id(String client_transaction_id) { 
			 this.client_transaction_id = client_transaction_id; } 
	    String client_transaction_id;
	    @JsonProperty("pics") 
	    public ArrayList<String> getPics() { 
			 return this.pics; } 
	    public void setPics(ArrayList<String> pics) { 
			 this.pics = pics; } 
	    ArrayList<String> pics;
	    @JsonProperty("instruction_details") 
	    public InstructionDetails getInstruction_details() { 
			 return this.instruction_details; } 
	    public void setInstruction_details(InstructionDetails instruction_details) { 
			 this.instruction_details = instruction_details; } 
	    InstructionDetails instruction_details;
	    @JsonProperty("committed_postings") 
	    public ArrayList<CommittedPosting> getCommitted_postings() { 
			 return this.committed_postings; } 
	    public void setCommitted_postings(ArrayList<CommittedPosting> committed_postings) { 
			 this.committed_postings = committed_postings; } 
	    ArrayList<CommittedPosting> committed_postings;
	    @JsonProperty("posting_violations") 
	    public ArrayList<PostingViolation> getPosting_violations() { 
			 return this.posting_violations; } 
	    public void setPosting_violations(ArrayList<PostingViolation> posting_violations) { 
			 this.posting_violations = posting_violations; } 
	    ArrayList<PostingViolation> posting_violations;
	    @JsonProperty("account_violations") 
	    public ArrayList<AccountViolation> getAccount_violations() { 
			 return this.account_violations; } 
	    public void setAccount_violations(ArrayList<AccountViolation> account_violations) { 
			 this.account_violations = account_violations; } 
	    ArrayList<AccountViolation> account_violations;
	    @JsonProperty("restriction_violations") 
	    public ArrayList<RestrictionViolation> getRestriction_violations() { 
			 return this.restriction_violations; } 
	    public void setRestriction_violations(ArrayList<RestrictionViolation> restriction_violations) { 
			 this.restriction_violations = restriction_violations; } 
	    ArrayList<RestrictionViolation> restriction_violations;
	    @JsonProperty("contract_violations") 
	    public ArrayList<ContractViolation> getContract_violations() { 
			 return this.contract_violations; } 
	    public void setContract_violations(ArrayList<ContractViolation> contract_violations) { 
			 this.contract_violations = contract_violations; } 
	    ArrayList<ContractViolation> contract_violations;
	    @JsonProperty("override") 
	    public Override getOverride() { 
			 return this.override; } 
	    public void setOverride(Override override) { 
			 this.override = override; } 
	    Override override;
	    @JsonProperty("transaction_code") 
	    public TransactionCode getTransaction_code() { 
			 return this.transaction_code; } 
	    public void setTransaction_code(TransactionCode transaction_code) { 
			 this.transaction_code = transaction_code; } 
	    TransactionCode transaction_code;
	    @JsonProperty("outbound_authorisation") 
	    public OutboundAuthorisation getOutbound_authorisation() { 
			 return this.outbound_authorisation; } 
	    public void setOutbound_authorisation(OutboundAuthorisation outbound_authorisation) { 
			 this.outbound_authorisation = outbound_authorisation; } 
	    OutboundAuthorisation outbound_authorisation;
	}

	public class PostingInstructionBatches{
	    @JsonProperty("KEY") 
	    public KEY getKEY() { 
			 return this.kEY; } 
	    public void setKEY(KEY kEY) { 
			 this.kEY = kEY; } 
	    KEY kEY;
	}

	public class PostingViolation{
	    @JsonProperty("type") 
	    public String getType() { 
			 return this.type; } 
	    public void setType(String type) { 
			 this.type = type; } 
	    String type;
	}

	public class Restrictions{
	    @JsonProperty("all") 
	    public boolean getAll() { 
			 return this.all; } 
	    public void setAll(boolean all) { 
			 this.all = all; } 
	    boolean all;
	    @JsonProperty("restriction_set_ids") 
	    public ArrayList<String> getRestriction_set_ids() { 
			 return this.restriction_set_ids; } 
	    public void setRestriction_set_ids(ArrayList<String> restriction_set_ids) { 
			 this.restriction_set_ids = restriction_set_ids; } 
	    ArrayList<String> restriction_set_ids;
	}

	public class RestrictionViolation{
	    @JsonProperty("restriction_set_id") 
	    public String getRestriction_set_id() { 
			 return this.restriction_set_id; } 
	    public void setRestriction_set_id(String restriction_set_id) { 
			 this.restriction_set_id = restriction_set_id; } 
	    String restriction_set_id;
	    @JsonProperty("account_id") 
	    public String getAccount_id() { 
			 return this.account_id; } 
	    public void setAccount_id(String account_id) { 
			 this.account_id = account_id; } 
	    String account_id;
	    @JsonProperty("payment_device_id") 
	    public String getPayment_device_id() { 
			 return this.payment_device_id; } 
	    public void setPayment_device_id(String payment_device_id) { 
			 this.payment_device_id = payment_device_id; } 
	    String payment_device_id;
	    @JsonProperty("customer_id") 
	    public String getCustomer_id() { 
			 return this.customer_id; } 
	    public void setCustomer_id(String customer_id) { 
			 this.customer_id = customer_id; } 
	    String customer_id;
	    @JsonProperty("requires_review") 
	    public boolean getRequires_review() { 
			 return this.requires_review; } 
	    public void setRequires_review(boolean requires_review) { 
			 this.requires_review = requires_review; } 
	    boolean requires_review;
	}

	public class Root{
	    @JsonProperty("posting_instruction_batches") 
	    public PostingInstructionBatches getPosting_instruction_batches() { 
			 return this.posting_instruction_batches; } 
	    public void setPosting_instruction_batches(PostingInstructionBatches posting_instruction_batches) { 
			 this.posting_instruction_batches = posting_instruction_batches; } 
	    PostingInstructionBatches posting_instruction_batches;
	}

	public class TargetAccount{
	    @JsonProperty("payment_device_token") 
	    public String getPayment_device_token() { 
			 return this.payment_device_token; } 
	    public void setPayment_device_token(String payment_device_token) { 
			 this.payment_device_token = payment_device_token; } 
	    String payment_device_token;
	}

	public class TransactionCode{
	    @JsonProperty("domain") 
	    public String getDomain() { 
			 return this.domain; } 
	    public void setDomain(String domain) { 
			 this.domain = domain; } 
	    String domain;
	    @JsonProperty("family") 
	    public String getFamily() { 
			 return this.family; } 
	    public void setFamily(String family) { 
			 this.family = family; } 
	    String family;
	    @JsonProperty("subfamily") 
	    public String getSubfamily() { 
			 return this.subfamily; } 
	    public void setSubfamily(String subfamily) { 
			 this.subfamily = subfamily; } 
	    String subfamily;
	}

	@KafkaListener(topics = {
	"vault.api.v1.postings.posting_instruction_batch.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
public void posting_instructions_batch(String message) throws IOException,NullPointerException

{

System.out.println(message);
ObjectMapper ob=new ObjectMapper();
//testing root=ob.readValue(message, testing.class);
JsonNode root=ob.readTree(message);
JsonNode posting_instructions=root.findValue("posting_instructions");
JsonNode batch_details=root.findValue("batch_details").get("Account Holder Name");
JsonNode committed_postings=posting_instructions.findValue("committed_postings");
JsonNode transaction_code=posting_instructions.findValue("transaction_code");
String id=root.findValue("id").asText();
String create_request_id=root.findValue("create_request_id").asText();

String client_id=root.findValue("client_id").asText();
String client_batch_id=root.findValue("client_batch_id").asText();
String event_id=root.findValue("event_id").asText();
String capture_timestamp=root.findValue("capture_timestamp").asText();
String value_timestamp=root.findValue("value_timestamp").asText();

String status=root.findValue("status").asText();
String error=root.findValue("error").asText();
String insertion_timestamp=root.findValue("insertion_timestamp").asText();

String dry_run=root.findValue("dry_run").asText();

String posting_instructions_id=posting_instructions.findValue("id").asText();

String amount=posting_instructions.findValue("amount").asText();
String denomination=posting_instructions.findValue("denomination").asText();
String account_id=posting_instructions.findValue("account_id").asText();
//String internal_account_id=posting_instructions.findValue("internal_account_id").asText();
//String target_account_id=posting_instructions.findValue("target_account_id").asText();
//String advice=posting_instructions.findValue("advice").asText();
//String category=posting_instructions.findValue("category").asText();
//String scheme_name=posting_instructions.findValue("scheme_name").asText();
//String settlement_date=posting_instructions.findValue("settlement_date").asText();
//String phase=committed_postings.findValue("phase").asText();
//String type=posting_instructions.findValue("type").asText();
//String reason=posting_instructions.findValue("reason").asText();
//String account_holder_name=batch_details.asText();
//String domain=transaction_code.get("domain").asText();
//String family=transaction_code.get("family").asText();
//String subfamily=transaction_code.get("subfamily").asText();
//



System.out.println(id+create_request_id+client_id+client_batch_id+event_id+capture_timestamp+value_timestamp+status+error+insertion_timestamp+dry_run+posting_instructions_id+amount+denomination+account_id);

//System.out.println(".................................,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"+id+posting_instructions+"?????????????????????????????????????????????????"+committed_postings);
}

}
