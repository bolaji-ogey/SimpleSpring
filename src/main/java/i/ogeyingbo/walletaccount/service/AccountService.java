/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.service;

import i.ogeyingbo.walletaccount.dao.PGAccountInterface;
import lombok.extern.slf4j.Slf4j; 
import i.ogeyingbo.walletaccount.entities.Account;
import i.ogeyingbo.walletaccount.entities.AccountProfile;
import i.ogeyingbo.walletaccount.model.AccountModel;
import i.ogeyingbo.walletaccount.model.AccountNameModel;
import i.ogeyingbo.walletaccount.model.AccountProfileModel;
import i.ogeyingbo.walletaccount.model.AccountStatementModel;
import i.ogeyingbo.walletaccount.model.AccountTrxnListModel;
import i.ogeyingbo.walletaccount.model.FundTransferModel;
import i.ogeyingbo.walletaccount.model.TrxnHistoryModel;
import i.ogeyingbo.walletaccount.repository.AccountProfileRepository;
import i.ogeyingbo.walletaccount.repository.AccountRepository;
import java.util.ArrayList;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

@Slf4j
@Service
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
        
        jsonObject.put("data", accountProfileModel.convertToJSON());
        
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
   
   
   
  
   
    
   public  JSONObject  getAccountStatement(AccountStatementModel    accountStatementModel){
        
           JSONObject   jsonObject =  new JSONObject();
           JSONArray   jsonArray  =  new  JSONArray(); 

            try { 
              
                 ArrayList<TrxnHistoryModel>   trxnHistoryModels  = pgAccountInterface.getAccountStatement(accountStatementModel);
                 
                if(trxnHistoryModels.size()  > 0){

                     jsonObject.put("responseCode", "00");
                     jsonObject.put("responseMessage", "Account profile is found ");

                     jsonArray.putAll(trxnHistoryModels); 

                     jsonObject.put("data", jsonArray);

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




    public  JSONObject  doFundTransfer(FundTransferModel  fundTransferModel){
         JSONObject   jsonObject =  new JSONObject();
        jsonObject.put("data", "-");
        StringBuilder  responseMssg  =  new StringBuilder(50);
        try { 

         if(pgAccountInterface.doFundTransfer(fundTransferModel) == 2){
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



    public  JSONObject  getTrxnStatus(String  inTrxnReference){
            JSONObject   jsonObject =  new JSONObject();
            JSONObject   respData =  new JSONObject(); 

            try { 
             
                TrxnHistoryModel   trxnHistoryModel  = pgAccountInterface.getTrxnStatus(inTrxnReference);
                
              if(trxnHistoryModel !=  null){

                jsonObject.put("responseCode", "00");
                jsonObject.put("responseMessage", "Account profile is found ");
  
                jsonObject.put("data", trxnHistoryModel.convertToJSON());
                
              }else{
                 StringBuilder  responseMssg  =  new StringBuilder(50);
                 responseMssg.append("Transaction with reference:  ").append(inTrxnReference).append(" could NOT be found");
                 jsonObject.put("responseCode", "07");
                 jsonObject.put("responseMessage", responseMssg);
                 jsonObject.put("data", "-");
              }
            } catch (Exception e) {
             // log.debug("Some internal error occurred", e);
                 StringBuilder  responseMssg  =  new StringBuilder(50);
                 responseMssg.append("Error occured while getting transaction for transaction reference:  ").append(inTrxnReference);
                 jsonObject.put("responseCode", "03");
                 jsonObject.put("responseMessage", responseMssg);
                 jsonObject.put("data", "-");
            }
            return   jsonObject;

    }



    
    
    
   public  JSONObject  getAccountTrxnList(AccountTrxnListModel  inAccountTrxnListModel){
  
               JSONObject   jsonObject =  new JSONObject();
               JSONArray   jsonArray  =  new  JSONArray(); 

                try { 
                    
                    ArrayList<TrxnHistoryModel>   trxnHistoryModels  = pgAccountInterface.getAccountTrxnList(inAccountTrxnListModel);
                  
                  if(trxnHistoryModels.size()  > 0){

                    jsonObject.put("responseCode", "00");
                    jsonObject.put("responseMessage", "Account profile is found ");
                    
                    jsonArray.putAll(trxnHistoryModels); 

                    jsonObject.put("data", jsonArray);
                    
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

   
  
 
  
  
  
    
}
