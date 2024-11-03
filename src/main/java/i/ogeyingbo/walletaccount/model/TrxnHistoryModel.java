/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"transactionResponseCode", "transactionDate", "transactionAmount", "transactionStatus", "transactionEvent", 
                         "transactionType",  "narration",  "currency", "transactionReference", "beneficiaryAccount", 
                                             "beneficiaryAccountName",   "beneficiaryBankCode", "beneficiaryBankName" })
@Getter @Setter @NoArgsConstructor 
public class TrxnHistoryModel {
    
    @JsonProperty("transactionResponseCode")
    private  String    transactionResponseCode;
    
    @JsonProperty("transactionDate")
    private  String    transactionDate;
    
    @JsonProperty("transactionAmount")
    private  BigDecimal  transactionAmount;
    
    @JsonProperty("transactionStatus")
    private  String    transactionStatus;
    
    @JsonProperty("transactionEvent")
    private  String   transactionEvent; 
    
    @JsonProperty("transactionType")
    private  String  transactionType; 
    
    @JsonProperty("narration")
    private  String  narration; 
    
    @JsonProperty("currency")
    private  String  currency; 
    
    @JsonProperty("transactionReference")
    private  String  transactionReference;
    
    @JsonProperty("beneficiaryAccount")
    private  String  beneficiaryAccount; 
    
    @JsonProperty("beneficiaryAccountName")
    private  String  beneficiaryAccountName; 
    
    @JsonProperty("beneficiaryBankCode")
    private  String  beneficiaryBankCode; 
    
    @JsonProperty("beneficiaryBankName")
    private  String   beneficiaryBankName;
    
            
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
    
    
}
