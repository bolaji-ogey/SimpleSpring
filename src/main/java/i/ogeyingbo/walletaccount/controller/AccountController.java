/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.controller;

 
import i.ogeyingbo.walletaccount.entities.Account;
import i.ogeyingbo.walletaccount.entities.AccountProfile;
import i.ogeyingbo.walletaccount.model.AccountProfileModel;
import i.ogeyingbo.walletaccount.model.AccountStatementModel;
import i.ogeyingbo.walletaccount.model.AccountTrxnListModel;
import i.ogeyingbo.walletaccount.model.FundTransferModel;
import i.ogeyingbo.walletaccount.model.TrxnStatusQueryModel;
import i.ogeyingbo.walletaccount.requests.AccountBlockReq;
import i.ogeyingbo.walletaccount.requests.AccountLookupReq;
import i.ogeyingbo.walletaccount.requests.AccountNameEnquiryReq;
import i.ogeyingbo.walletaccount.requests.AccountNameUpdateReq;
import i.ogeyingbo.walletaccount.requests.AccountStatementReq;
import i.ogeyingbo.walletaccount.requests.AccountTrxnListReq;
import i.ogeyingbo.walletaccount.requests.AccountUnblockReq;
import i.ogeyingbo.walletaccount.requests.FundTransferReq;
import i.ogeyingbo.walletaccount.requests.OpenAccountReq;
import i.ogeyingbo.walletaccount.requests.TrxnStatusQueryReq;
import i.ogeyingbo.walletaccount.service.AccountService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j; 
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

//@Controller
@RestController
@Slf4j
@RequestMapping("/account-services")
public class AccountController {
    
  @Autowired
  private  AccountService  accountService;
  
  
  @GetMapping("/")
  public String home() {
    return "redirect:/account/view";
  }
  
  
@PostMapping("/account_open")
ResponseEntity<String>   createAccount(@Valid @RequestBody  OpenAccountReq   newAccountOpen) {
     AccountProfile   accountProfile = new AccountProfile();
     accountProfile.initAccountProfile(newAccountOpen);
     
     Account   account = new Account();
     account.initAccount(newAccountOpen);
     
     JSONObject   jsonObject = accountService.createNewAccount(accountProfile, account);
   // return ResponseEntity.ok("Account is created");   
   return ResponseEntity.ok(jsonObject.toString());  
}




@PostMapping("/account_block")
ResponseEntity<String>   accountBlock(@Valid @RequestBody   AccountBlockReq   accountBlock) {  
    JSONObject   jsonObject =   accountService.blockAccount(accountBlock.getAccountNumber(),   accountBlock.getReason());
  //  return ResponseEntity.ok("Account is blocked");  
    return ResponseEntity.ok(jsonObject.toString()); 
}



@PostMapping("/account_unblock")
ResponseEntity<String>   accountUnblock(@Valid @RequestBody   AccountUnblockReq   accountUnblock){ 
     JSONObject   jsonObject =  accountService.unBlockAccount(accountUnblock.getAccountNumber(),   accountUnblock.getReason());
   // return ResponseEntity.ok("Account is unblocked");   
   return ResponseEntity.ok(jsonObject.toString());  
}



@PostMapping("/account_name_enquiry")
ResponseEntity<String>   accountNameEnquiry(@Valid @RequestBody   AccountNameEnquiryReq   accountNameEnquiryReq){ 
     JSONObject   jsonObject =  accountService.findByAccountNo(accountNameEnquiryReq.getAccountNumber(),   accountNameEnquiryReq.getBankCode());
    // return ResponseEntity.ok("Account is unblocked");  
    return ResponseEntity.ok(jsonObject.toString());  
}



@PostMapping("/account_details")
ResponseEntity<String>   accountDetails(@Valid @RequestBody   AccountNameEnquiryReq   accountNameEnquiryReq){ 
     JSONObject   jsonObject =  accountService.getAccountDetails(accountNameEnquiryReq.getAccountNumber());
    // return ResponseEntity.ok("Account is unblocked");  
    return ResponseEntity.ok(jsonObject.toString());  
}


@PostMapping("/account_name_update")
ResponseEntity<String>   accountNameUpdate(@Valid @RequestBody   AccountNameUpdateReq   accountNameUpdateReq){ 
    AccountProfileModel   accountProfileModel = new AccountProfileModel();
     accountProfileModel.initAccountProfile(accountNameUpdateReq);
     
     JSONObject   jsonObject =  accountService.updateAccountProfile(accountProfileModel);
   // return ResponseEntity.ok("Account is unblocked");   
   return ResponseEntity.ok(jsonObject.toString());  
}

 
@PostMapping("/account_profile")
ResponseEntity<String>   accountProfileDetail(@Valid @RequestBody   AccountLookupReq   inAccountLookupReq){ 
     JSONObject   jsonObject =  accountService.getAccountProfileDetail(inAccountLookupReq.getCustomerReference());
    // return ResponseEntity.ok("Account is unblocked");  
    return ResponseEntity.ok(jsonObject.toString());  
}


/***
 
@PostMapping("/account_statement")
ResponseEntity<String>   accountStatement(@Valid @RequestBody   AccountStatementReq   accountStatementReq){ 
    AccountStatementModel       accountStatementModel  = new  AccountStatementModel();
    accountStatementModel.initAccountStatement(accountStatementReq);
    JSONObject   jsonObject =   accountService.getAccountStatement(accountStatementModel);
   // return ResponseEntity.ok("Account is unblocked");  
   return ResponseEntity.ok(jsonObject.toString());  
}




@PostMapping("/fund_transfer")
ResponseEntity<String>   doFundTransfer(@Valid @RequestBody   FundTransferReq   fundTransferReq){ 
    FundTransferModel   fundTransferModel  =  new  FundTransferModel();
    fundTransferModel.initFundTransfer(fundTransferReq);
    JSONObject   jsonObject =   accountService.doFundTransfer(fundTransferModel);
   // return ResponseEntity.ok("Account is unblocked");  
   return ResponseEntity.ok(jsonObject.toString());  
}



@PostMapping("/transaction_status_query")
ResponseEntity<String>   trxnStatusQuery(@Valid @RequestBody   TrxnStatusQueryReq   accountStatementReq){  
    JSONObject   jsonObject =   accountService.getTrxnStatus(accountStatementReq.getTrxnReference());
   // return ResponseEntity.ok("Account is unblocked");  
   return ResponseEntity.ok(jsonObject.toString());  
}



@PostMapping("/account_trxn_list")
ResponseEntity<String>   accountTrxnList(@Valid @RequestBody   AccountTrxnListReq   accountTrxnListReq){
    AccountTrxnListModel    accountTrxnListModel  =  new  AccountTrxnListModel();
    accountTrxnListModel.initAccountTrxnList(accountTrxnListReq);
    JSONObject   jsonObject =   accountService.getAccountTrxnList(accountTrxnListModel);
   // return ResponseEntity.ok("Account is unblocked");  
   return ResponseEntity.ok(jsonObject.toString());  
}

***/ 
   
    
    
    
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        String  responseCode  =  "09";
        StringBuilder   responseMessg  = new StringBuilder(100);
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            responseMessg.append(fieldName).append(": ");
            responseMessg.append(error.getDefaultMessage()).append(",");
            // errors.put(fieldName, errorMessage);
        });
        errors.put("responseCode", responseCode);
        errors.put("responseMessage", responseMessg.toString());
        errors.put("data", null);
        return errors;
    }
    
    
    
    /****    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    ****/
    
    
  
    
}
