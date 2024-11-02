/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

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

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
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
    
    
