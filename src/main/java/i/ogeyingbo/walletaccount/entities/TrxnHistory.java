/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.entities;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */  
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 



@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name="transaction_history")
public class  TrxnHistory  {
    
    
    @JsonProperty("partnerCode")
    @Column(name = "partner_code", nullable = false)
    private String  partnerCode;
    
    @JsonProperty("schemeCode")
    @Column(name = "scheme_code", nullable = false)
    private String  schemeCode;
    
    @JsonProperty("processorNodeName")
    @Column(name = "processor_node_name", nullable = false)
    private String  processorNodeName;
    
    @JsonProperty("processorNodeIp")
    @Column(name = "processor_node_ip", nullable = false)
    private String  processorNodeIp;
    
    @JsonProperty("trxnReference")
    @Column(name = "trxn_reference", nullable = false)
    private String  trxnReference;
    
    @JsonProperty("processorReference")
    @Column(name = "processor_reference", nullable = false)
    private String  processorReference;
    
	
    @JsonProperty("processorAuthKeyHash")
    @Column(name = "processor_auth_key_hash", nullable = false)
    private String  processorAuthKeyHash;
    
    
    @JsonProperty("trxnEvent")
    @Column(name = "trxn_event", nullable = false)
    private String  trxnEvent;
    
    @JsonProperty("trxnType")
    @Column(name = "trxn_type", nullable = false)
    private String  trxnType;
    
    @JsonProperty("trxnMode")
    @Column(name = "trxn_mode", nullable = false)
    private String  trxnMode;
	   
	
    @JsonProperty("currencyName")
    @Column(name = "currency_name", nullable = false)
    private String  currencyName;
    
    @JsonProperty("currencyCode")
    @Column(name = "currency_code", nullable = false)
    private String  currencyCode;
    
    @JsonProperty("currencySymbol")
    @Column(name = "currency_symbol", nullable = false)
    private String  currencySymbol;
    
    @JsonProperty("trxnStartTime")
    @Column(name = "trxn_start_time", nullable = false)
    private String  trxnStartTime;
    
    @JsonProperty("trxnStartDate")
    @Column(name = "trxn_start_date", nullable = false)
    private String  trxnStartDate;
    
    
    @JsonProperty("trxnEndTime")
    @Column(name = "trxn_end_time", nullable = false)
    private String  trxnEndTime;
    
    @JsonProperty("trxnEndDate")
    @Column(name = "trxn_end_date", nullable = false)
    private String   trxnEndDate;
    
    @JsonProperty("senderName")
    @Column(name = "sender_name", nullable = false)
    private String   senderName;
    
    @JsonProperty("senderWallet")
    @Column(name = "sender_wallet", nullable = false)
    private String   senderWallet;
    
    @JsonProperty("recieverName")
    @Column(name = "reciever_name", nullable = false)
    private String   recieverName;
    
    
    @JsonProperty("recieverBankCode")
    @Column(name = "reciever_bank_code", nullable = false)
    private String   recieverBankCode;
    
    @JsonProperty("recieverAccount")
    @Column(name = "reciever_account", nullable = false)
    private String   recieverAccount;
	 
	
    @JsonProperty("recieverBank")
    @Column(name = "reciever_bank", nullable = false)
    private String   recieverBank;
    
    
    @JsonProperty("totalTrxnAmount")
    @Column(name = "total_trxn_amount", nullable = false)
    private BigDecimal   totalTrxnAmount = new BigDecimal(0.00);
    
    
    @JsonProperty("trxnValueAmount")
    @Column(name = "trxn_value_amount", nullable = false)
    private  BigDecimal   trxnValueAmount = new BigDecimal(0.00);
    
    
    @JsonProperty("totalTrxnFeeAmount")
    @Column(name = "total_trxn_fee_amount", nullable = false)
    private  BigDecimal   totalTrxnFeeAmount = new BigDecimal(0.00);
    
    
    @JsonProperty("trxnProcessCode")
    @Column(name = "trxn_process_code", nullable = false)
    private String   trxnProcessCode;
    
    @JsonProperty("trxnStatusCode")
    @Max(value=2)
    @Column(name = "trxn_status_code", nullable = false)
    private String   trxnStatusCode;
    
    @JsonProperty("trxnStatus")
    @Column(name = "trxn_status", nullable = false)
    private String   trxnStatus;
    
	
    @JsonProperty("authUserId")
    @Column(name = "auth_user_id", nullable = false)
    private String   authUserId;
    
    
    @JsonProperty("authFactor1KeyHash")
    @Column(name = "auth_factor_1_key_hash", nullable = false)
    private String   authFactor1KeyHash;
    
    
    @JsonProperty("authFactor2KeyHash")
    @Column(name = "auth_factor_2_key_hash", nullable = false)
    private String   authFactor2KeyHash;
    
    @JsonProperty("serviceProvider")
    @Column(name = "service_provider", nullable = false)
    private String   serviceProvider;
    
    
    @JsonProperty("serviceCustomerId")
    @Column(name = "service_customer_id", nullable = false)
    private String   serviceCustomerId;
 
    
    @JsonProperty("purchaseTokenEncrypt")
    @Column(name = "purchase_token_encrypt", nullable = false)
    private String   purchaseTokenEncrypt;
    
    @JsonProperty("purchaseTokenHash")
    @Column(name = "purchase_token_hash", nullable = false)
    private String   purchaseTokenHash;
    
    @JsonProperty("productProviderCustomerName")
    @Column(name = "product_provider_customer_name", nullable = false)
    private String   productProviderCustomerName;
    
    
    @JsonProperty("productProviderCustomerAddress")
    @Column(name = "product_provider_customer_address", nullable = false)
    private String   productProviderCustomerAddress;
    
    
    @JsonProperty("narration")
    @Column(name = "narration", nullable = false)
    private String   narration;
    
    
    @JsonProperty("isFinalized")
    @Column(name = "is_finalized", nullable = false)
    private  boolean   isFinalized = false;
    
    
    @JsonProperty("updateCheck")
    @Column(name = "update_check", nullable = false)
    private  long   updateCheck  =  -1;
    
	  
 
    
    
    
}
