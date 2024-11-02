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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.sql.Connection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
/***
@JsonPropertyOrder({"customerReference", "firstName", "middleName", "lastName",  
                           "email", "phoneNumber", "accountNumber" })
                           * ***/

@JsonPropertyOrder({"customerReference",  "lastName",  "email", "phoneNumber",
                            "dateOfBirth", "address", "location",  "state",  "country" })
@Getter @Setter @NoArgsConstructor    
public class AccountNameUpdateReq {
     
    @JsonProperty("customerReference")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private  String  customerReference;
    
    /***
    @JsonProperty("firstName")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  firstName;
    
    @JsonProperty("middleName")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  middleName;
    **/
    
    @JsonProperty("lastName")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  lastName;
     
     
      @JsonProperty("email")
    @NotBlank(message = "Email is required")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String  email;
    
    @JsonProperty("phoneNumber")
    @NotBlank(message = "Phone number is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  phoneNumber;
    
    @JsonProperty("dateOfBirth")
    @NotBlank(message = "Date of Birth is required")
    @Size(min = 10, max = 10, message = "Date of birth should be 10 characters") 
    @Past(message = "The date of birth must be in the past.")
    private String  dateOfBirth;
    
    
    @JsonProperty("address")
    @NotBlank(message = "Address is required")
    @Size(min = 8, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  address;
    
    @JsonProperty("location")
    @NotBlank(message = "Location is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  location;
    
    @JsonProperty("state")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  state;
    
    
    @JsonProperty("country")
    @NotBlank(message = "Country is required")
    @Size(min = 5, max = 20, message = "Country should be between 5 and 20 characters") 
    private String  country;
    
    /**
    @JsonProperty("accountNumber")
    @NotBlank(message = "Account number is required")
    @Digits(integer = 10, fraction = 0, message = "Account number should be 10 digits") 
    private String  accountNumber;
     ***/
    
    
    @JsonProperty("country")
    @NotBlank(message = "Data to update is required")
    @Size(min = 5, max = 20, message = "Data to update should be between 5 and 20 characters") 
    private String  dataToUpdate;
    
    
      
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
    
    
     
     
     
    
    public  static  AccountNameUpdateReq  readFromJSON(String  inObjectJSON){ 
        AccountNameUpdateReq  accountNameUpdateReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              accountNameUpdateReq = objectMapper.readValue(inObjectJSON, AccountNameUpdateReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  accountNameUpdateReq;
    }
      
    
     
    
}
