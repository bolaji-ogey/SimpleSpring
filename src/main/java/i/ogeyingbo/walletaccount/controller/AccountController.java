/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.controller;

import i.ogeyingbo.simplespring.entities.Profile;
import i.ogeyingbo.walletaccount.entities.Account;
import i.ogeyingbo.walletaccount.entities.AccountProfile;
import i.ogeyingbo.walletaccount.requests.AccountBlockReq;
import i.ogeyingbo.walletaccount.requests.AccountNameEnquiryReq;
import i.ogeyingbo.walletaccount.requests.AccountNameUpdateReq;
import i.ogeyingbo.walletaccount.requests.AccountStatementReq;
import i.ogeyingbo.walletaccount.requests.AccountUnblockReq;
import i.ogeyingbo.walletaccount.requests.OpenAccountReq;
import i.ogeyingbo.walletaccount.service.AccountService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

//@Controller
@RestController
@Slf4j
@RequestMapping("/account-service")
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
    AccountProfile   accountProfile = new AccountProfile();
     accountProfile.initAccountProfile(accountNameUpdateReq);
     
     accountService.doAccountNameUpdate(accountProfile);
   // return ResponseEntity.ok("Account is unblocked");   
   return ResponseEntity.ok(jsonObject.toString());  
}



@PostMapping("/account_statement")
ResponseEntity<String>   accountStatement(@Valid @RequestBody   AccountStatementReq   accountStatementReq){ 
    JSONObject   jsonObject =   accountService.getAccountStatement(AccountStatementReq.getAccountNumber(),   AccountStatementReq.getBankCode());
   // return ResponseEntity.ok("Account is unblocked");  
   return ResponseEntity.ok(jsonObject.toString());  
}



  @GetMapping("/")
  public String home() {

    return "redirect:/profiles/view";
  }

  @GetMapping("/profiles/view")
  public ModelAndView view(Model model) {

    return new ModelAndView("view", "profiles", profileService.getAll());
  }

  
  @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
  public ByteArrayResource downloadImage(@PathVariable Long imageId) {
    byte[] image = profileService.findById(imageId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        .getImageData();

    return new ByteArrayResource(image);
  }

  
  
  @GetMapping("/profiles/add")
  public ModelAndView addProfile() {

    return new ModelAndView("addProfile", "profile", new Profile());
  }

  @PostMapping(value = "/profiles/add", consumes = MULTIPART_FORM_DATA_VALUE)
  public String handleProfileAdd(Profile profile, @RequestPart("file") MultipartFile file) {

   //  log.info("handling request parts: {}", file);
    profileService.save(profile, file);
    return "redirect:/profiles/view";
  }
  
  
  
     @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User is valid");
    }
  
   
    
    
   
    
    
    
    
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
