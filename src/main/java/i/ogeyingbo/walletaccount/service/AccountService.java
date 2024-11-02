/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.service;

import i.ogeyingbo.walletaccount.dao.PGAccountInterface;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j; 
import i.ogeyingbo.walletaccount.entities.Account;
import i.ogeyingbo.walletaccount.entities.AccountProfile;
import i.ogeyingbo.walletaccount.model.AccountModel;
import i.ogeyingbo.walletaccount.model.AccountNameModel;
import i.ogeyingbo.walletaccount.model.AccountProfileModel;
import i.ogeyingbo.walletaccount.repository.AccountProfileRepository;
import i.ogeyingbo.walletaccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Service
@Slf4j
public class AccountService {
    
  @Autowired
  private  AccountProfileRepository    accountProfileRepository;
  
  @Autowired
  private  AccountRepository    accountRepository;
  
  private  PGAccountInterface  pgAccountInterface  =   PGAccountInterface.getInstance();
  
  

  public  JSONObject   createNewAccount(AccountProfile  accountProfile, Account  account) {
    JSONObject   jsonObject =  new JSONObject();
    jsonObject.put("data", "-");
   StringBuilder  responseMssg  =  new StringBuilder(50);
    try { 
      accountProfileRepository.save(accountProfile);
      accountRepository.save(account);
      jsonObject.put("responseCode", "00");
      jsonObject.put("responseMessage", "Account is created");
      jsonObject.put("data", "-");
    } catch (Exception e) {     
        responseMssg.append("Error occured while trying to create account: ").append(account.getAccountName());
        jsonObject.put("responseCode", "03");
        jsonObject.put("responseMessage", responseMssg.toString());
        // log.debug("Some internal error occurred", e);
    }
    return   jsonObject;
  }

  
  
  
  public  JSONObject  blockAccount(String inAccountNo,  String  inReason) {
   JSONObject   jsonObject =  new JSONObject();
   jsonObject.put("data", "-");
   StringBuilder  responseMssg  =  new StringBuilder(50);
    try { 
      if(pgAccountInterface.blockAccount(inAccountNo.trim(), inReason) == 1){
         responseMssg.append("Account: ").append(inAccountNo.trim()).append(" is blocked");
         jsonObject.put("responseCode", "00");
         jsonObject.put("responseMessage", responseMssg.toString()); 
      }else{
         responseMssg.append("Account: ").append(inAccountNo.trim()).append(" cannot be found");
         jsonObject.put("responseCode", "07");
         jsonObject.put("responseMessage", responseMssg.toString()); 
      }
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
        responseMssg.append("Error occured while trying to block account: ").append(inAccountNo.trim());
        jsonObject.put("responseCode", "03");
        jsonObject.put("responseMessage", responseMssg.toString());
        // log.debug("Some internal error occurred", e);
    }
    return   jsonObject;
  }
  
  
  
  
  public  JSONObject  unBlockAccount(String inAccountNo,  String  inReason) {
    JSONObject   jsonObject =  new JSONObject();
    jsonObject.put("data", "-");
    StringBuilder  responseMssg  =  new StringBuilder(50);
    try { 
      
     if(pgAccountInterface.unBlockAccount(inAccountNo, inReason) == 1){
        responseMssg.append("Account: ").append(inAccountNo.trim()).append(" is un-blocked");
         jsonObject.put("responseCode", "00");
         jsonObject.put("responseMessage", responseMssg.toString()); 
      }else{
         responseMssg.append("Account: ").append(inAccountNo.trim()).append(" cannot be found");
         jsonObject.put("responseCode", "07");
         jsonObject.put("responseMessage", responseMssg.toString()); 
      }
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
        responseMssg.append("Error occured while trying to un-block account: ").append(inAccountNo.trim());
        jsonObject.put("responseCode", "03");
        jsonObject.put("responseMessage", responseMssg.toString());
    }
    return   jsonObject;
  }
  
  
  
  
   public  JSONObject  findByAccountNo(String    inAccountNo, String inBankCode) {
    JSONObject   jsonObject =  new JSONObject();
    JSONObject   respData =  new JSONObject();
    JSONObject   accountProvider =  new JSONObject();
    try { 
        if(inBankCode.equalsIgnoreCase("321")){
            AccountModel   accountModel  = pgAccountInterface.findByAccountNo(inAccountNo);
            if(accountModel !=  null){

              jsonObject.put("responseCode", "00");
              jsonObject.put("responseMessage", "Account is created");

              respData.put("accountNumber", accountModel.getAccountNumber());
              respData.put("accountName", accountModel.getAccountName());

              accountProvider.put("bankCode", "321");
              accountProvider.put("bankName", "open_cooperative");

              respData.put("providerBank", accountProvider);

              jsonObject.put("data", respData);
            }else{
               StringBuilder  responseMssg  =  new StringBuilder(50);
               responseMssg.append("Account number:  ").append(inAccountNo).append(" could NOT be found");
               jsonObject.put("responseCode", "07");
               jsonObject.put("responseMessage", responseMssg);
               jsonObject.put("data", "-");
            }
        }else{
            // get account detail from bank
            
        }
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Error occured while finding account number:  ").append(inAccountNo);
         jsonObject.put("responseCode", "03");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-");
    }
    return   jsonObject;
  }
   
   
   
  
  
  public  JSONObject  getAccountDetails(String    inAccountNo) {
    JSONObject   jsonObject =  new JSONObject();
    JSONObject   respData =  new JSONObject();
     JSONObject   accountProvider =  new JSONObject();
    try { 
      AccountModel   accountModel  = pgAccountInterface.getAccountDetail(inAccountNo);
      if(accountModel !=  null){
          
        jsonObject.put("responseCode", "00");
        jsonObject.put("responseMessage", "Account is created");
        
        respData.put("accountNumber", accountModel.getAccountNumber());
        respData.put("accountName", accountModel.getAccountName());
        
        accountProvider.put("bankCode", "321");
        accountProvider.put("bankName", "open_cooperative");
        
        respData.put("providerBank", accountProvider);
        
        jsonObject.put("data", respData);
      }else{
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Account number:  ").append(inAccountNo).append(" could NOT be found");
         jsonObject.put("responseCode", "07");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-");
      }
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Error occured while finding account number:  ").append(inAccountNo);
         jsonObject.put("responseCode", "03");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-");
    }
    return   jsonObject;
  }
   
  
 
  
  
  
  public  JSONObject  updateAccountProfile(AccountProfileModel   inAccountProfileModel) {
    JSONObject   jsonObject =  new JSONObject();
    JSONObject   respData =  new JSONObject();
    JSONObject   accountProvider =  new JSONObject();
    try { 
      if(pgAccountInterface.updateAccountProfile(inAccountProfileModel)  == 1){
          AccountNameModel   accountNameModel  = pgAccountInterface.getAccountNumberAndProfileName(inAccountProfileModel.getCustomerReference());
            jsonObject.put("responseCode", "00");
            jsonObject.put("responseMessage", "Account is updated");
            
              respData.put("accountNumber", accountNameModel.getAccountNumber());
              respData.put("accountName", accountNameModel.getAccountName());

              accountProvider.put("bankCode", "321");
              accountProvider.put("bankName", "open_cooperative");

              respData.put("providerBank", accountProvider);

              jsonObject.put("data", respData);
      }else{
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Error occured while updating account:  ").append(inAccountProfileModel.getOldAccountName());
         jsonObject.put("responseCode", "03");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-"); 
      }
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Error occured while trying to update account for profile:  ").append(inAccountProfileModel.getCustomerReference());
         jsonObject.put("responseCode", "03");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-");
    }
    return   jsonObject;
  }
  
  
  
  
   public  JSONObject  getAccountProfileDetail(String    inCustomerRef) {
    JSONObject   jsonObject =  new JSONObject();
    JSONObject   respData =  new JSONObject(); 
    
    try { 
      AccountProfileModel   accountProfileModel  = pgAccountInterface.getAccountProfileDetail(inCustomerRef);
      if(accountProfileModel !=  null){
          
        jsonObject.put("responseCode", "00");
        jsonObject.put("responseMessage", "Account profile is found ");
         
        respData.put("customerReference", accountProfileModel.getCustomerReference());
         
        respData.put("firstName", accountProfileModel.getFirstName()); 
        respData.put("middleName", accountProfileModel.getMiddleName());
        respData.put("lastName", accountProfileModel.getLastName());     
     
        respData.put("bvn", accountProfileModel.getBvn()); 
        respData.put("email", accountProfileModel.getEmail());
        respData.put("phoneNumber", accountProfileModel.getPhoneNumber());
        respData.put("dateOfBirth", accountProfileModel.getDateOfBirth());
        respData.put("address", accountProfileModel.getAddress());
        respData.put("location", accountProfileModel.getLocation());
        respData.put("state", accountProfileModel.getState());
        
        respData.put("country", accountProfileModel.getCountry());
        
        jsonObject.put("data", respData);
      }else{
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Account profile:  ").append(inCustomerRef).append(" could NOT be found");
         jsonObject.put("responseCode", "07");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-");
      }
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
         StringBuilder  responseMssg  =  new StringBuilder(50);
         responseMssg.append("Error occured while finding account profile:  ").append(inCustomerRef);
         jsonObject.put("responseCode", "03");
         jsonObject.put("responseMessage", responseMssg);
         jsonObject.put("data", "-");
    }
    return   jsonObject;
  }
   
   
   
   
   
  
  
  public JSONObject  getAccountStatement(Account  account) {
    JSONObject   jsonObject =  new JSONObject();
    try { 
      accountRepository.save(account);
      jsonObject.put("responseCode", "00");
      jsonObject.put("responseMessage", "Account is created");
      jsonObject.put("data", "-");
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
    }
    return   jsonObject;
  }
  
  
  public  JSONObject creatiNewAccount(Account  account) {
      JSONObject   jsonObject =  new JSONObject();
    try { 
      accountRepository.save(account);
      jsonObject.put("responseCode", "00");
      jsonObject.put("responseMessage", "Account is created");
      jsonObject.put("data", "-");
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
    }
    return   jsonObject;
  }
  
  
  /**
  public List<Profile> getAll() {
    return profileRepository.findAll();
  }
**/
  
  
  public  Optional<Account> findByAccountNumber(String  accountNumber) {
    return    accountRepository.findByAccountNumber(accountNumber);
  }
  
  
  
  
    
}
