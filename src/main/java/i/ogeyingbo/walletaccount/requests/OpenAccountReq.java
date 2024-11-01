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
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"customerReference", "firstName", "middleName", "lastName", "bvn",
                           "email", "phoneNumber", "dateOfBirth", "address", "location", 
                             "state",  "country", "productCode"})
@Getter @Setter @NoArgsConstructor    
public class OpenAccountReq {
     
    @JsonProperty("customerReference")
    @NotBlank(message = "Customer reference is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private  String  customerReference;
    
    @JsonProperty("firstName")
    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  firstName;
    
    @JsonProperty("middleName")
    @NotBlank(message = "Middle name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
    private String  middleName;
    
    @JsonProperty("lastName")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters") 
   // @Pattern(regexp = "^\\d{1,5}$", flags = { Flag.CASE_INSENSITIVE, Flag.MULTILINE }, message = "The Zip code is invalid.")
    private String  lastName;
     
    
    @JsonProperty("bvn")
    @NotBlank(message = "BVN is required") 
    @Digits(integer = 11, fraction = 0, message = "BVN should be 11 digits")
    private String  bvn;
    
    @JsonProperty("email")
    @NotBlank(message = "Email is required")
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
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
    
    
    @JsonProperty("productCode")
    @NotBlank(message = "Product code is required")
    @Size(min = 3, max = 6, message = "Product code should be between 3 and 6 characters") 
    private String  productCode;
    
    
      
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
    
    
     
    public  static  OpenAccountReq  readFromJSON(String  inObjectJSON){ 
        OpenAccountReq  openAccountReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              openAccountReq = objectMapper.readValue(inObjectJSON, OpenAccountReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  openAccountReq;
    }
      
    
     
    
    
}
