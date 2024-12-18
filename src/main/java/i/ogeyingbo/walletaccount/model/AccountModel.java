/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"requestId", "customerReference", "accountNumber", "accountName", "bankCode", "bvn",
                           "isActive", "dateOpened", "lastTrxnDate", "lastCreditDate", "lastDebitDate" })
@Getter @Setter @NoArgsConstructor 
public class AccountModel {
     
    private long id;
     
    private  String  requestId;
 
    private  String  customerReference;
     
    private String  accountNumber;
     
    private String  accountName;
     
    private String  bankCode;
     
     
    private String  bvn;
     
    private  boolean  isActive = true;
    
 
    private String  dateOpened;
    
     
    private String  lastTrxnDate;
     
    private String  lastCreditDate;
    
      
    private String  lastDebitDate;
    
      
    
    
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
