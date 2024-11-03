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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size; 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"accountNumber", "reason"})
@Getter @Setter @NoArgsConstructor 
public class AccountUnblockReq {
    
    
    @JsonProperty("requestId")
    @NotBlank(message = "Request Id is required")
    @Size(min = 8, max = 12, message = "Request Id should be between  8 to 12 characters ") 
    private  String  requestId;
    
    @JsonProperty("accountNumber")
    @NotBlank(message = "Account number is required")
    @Digits(integer = 11, fraction = 0, message = "Account number should be 10 digits") 
    private  String  accountNumber;
    
    
    @JsonProperty("reason")
    @NotBlank(message = "Reason is required")
   // @Size(min = 8, max = 20, message = "Invalid reason. Reason should be between 8 and 20 characters") 
    private  String  reason;
    
    
      
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
    
    
     
     
    
    public  static  AccountUnblockReq  readFromJSON(String  inObjectJSON){ 
        AccountUnblockReq  accountUnblockReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              accountUnblockReq = objectMapper.readValue(inObjectJSON, AccountUnblockReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  accountUnblockReq;
    }
      

}