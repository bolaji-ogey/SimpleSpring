/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"sourceAccount", "trxnReference", "trxnAmount", "beneficiaryAccount", 
                               "beneficiaryAccountName", "beneficiaryBankCode", "narration" })
@Getter @Setter @NoArgsConstructor  
public class FundTransferReq { 
    
    @JsonProperty("sourceAccount")
    @NotBlank(message = "Source account  is required")
    @Digits(integer = 10, fraction = 0, message = "Source account should be 10 digits")
    private  String  sourceAccount;
    
    @JsonProperty("trxnReference")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  trxnReference;
    
    @JsonProperty("trxnAmount")
    @NotBlank(message = "Transaction amount is required")
    @Min(value = 1, message = "Minimum value cannot be less than 1")
    @Max(value = 1000000000, message = "Maximum value cannot be more than 1000000000")
    @Positive(message = "Trxn amount must be a positive value")
    @Digits(integer = 10, fraction = 2, message = "Transaction account should be 10 digits")
    private  BigDecimal  trxnAmount =  new BigDecimal(0.00);
    
    @JsonProperty("beneficiaryAccount")
    @NotBlank(message = "Beneficiary account is required")
    @Digits(integer = 10, fraction = 0, message = "Beneficiary account should be 10 digits") 
    private String  beneficiaryAccount;
     
     
     @JsonProperty("beneficiaryAccountName")
    @NotBlank(message = "Beneficiary account name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  beneficiaryAccountName;
     
     
    @JsonProperty("beneficiaryBankCode")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 6, message = "Last name should be between 3 and 20 characters") 
    private String  beneficiaryBankCode;
    
    
    @JsonProperty("narration")
    @NotBlank(message = "Narration is required")
    //@Size(min = 3, max = 6, message = "Narration be between 3 and 20 characters") 
    private String  narration;
    
    
     
      
    public  final  JSONObject  convertToJSON(){
        JSONObject  returnedJson =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
           returnedJson =  new JSONObject(objectMapper.writeValueAsString(this));
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJson;
    }
    
    
    public  final  String  convertToJSONString(){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
    }
    
    
     
     
     
    
    public  static  FundTransferReq  readFromJSON(String  inObjectJSON){ 
        FundTransferReq    fundTransferReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fundTransferReq = objectMapper.readValue(inObjectJSON, FundTransferReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fundTransferReq;
    }
      
    
    
     
}
