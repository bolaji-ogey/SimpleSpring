/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import i.ogeyingbo.walletaccount.requests.AccountNameUpdateReq;
import i.ogeyingbo.walletaccount.requests.OpenAccountReq;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
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
public class AccountProfileModel {
    
     private String  dataToUpdate;
 
    private  String  customerReference;
     
    private String  firstName;
     
    private String  middleName;
     
    private String  lastName;
     
    private String  bvn;
    
    private String  email;
     
    private String  phoneNumber;
     
    private String  dateOfBirth;
     
    private String  address;
     
    private String  location;
     
    private String  state;
    
      
    private String  country;
    
     
    private String  productCode;
       
    private  boolean   isActive;
    
    
    
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
    
    
    
    
    
    public  void  initAccountProfile(AccountNameUpdateReq   inAccountNameUpdateReq){
        
        dataToUpdate   =  inAccountNameUpdateReq.getDataToUpdate();
                
        customerReference  =  inAccountNameUpdateReq.getCustomerReference(); 
        lastName  =  inAccountNameUpdateReq.getLastName();
        
        dateOfBirth  =  inAccountNameUpdateReq.getDateOfBirth();
         
        email   =  inAccountNameUpdateReq.getEmail();
        phoneNumber  =  inAccountNameUpdateReq.getPhoneNumber();
         
        address   =  inAccountNameUpdateReq.getAddress();
        location  =  inAccountNameUpdateReq.getLocation();
        
        state  =  inAccountNameUpdateReq.getState();
        country   =  inAccountNameUpdateReq.getCountry();  
    }
    


     public  String  getOldAccountName(){
        StringBuilder   newAccountName  =  new StringBuilder(130);
            newAccountName.append(firstName).append(" ").append(middleName);
            newAccountName.append(" ").append(lastName);
        return   newAccountName.toString();
    }
    
    
    
}
    
    
