/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.controller;

import i.ogeyingbo.simplespring.entities.Profile;
import i.ogeyingbo.walletaccount.requests.OpenAccountReq;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.User;
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
@RequestMapping("/account")
public class AccountController {
    
  @Autowired
  private  AccounteService  accountService;
  
  
  @GetMapping("/")
  public String home() {

    return "redirect:/profiles/view";
  }
  
  
@PostMapping("/account_open")
ResponseEntity<String>   createAccount(@Valid @RequestBody  OpenAccountReq   newAccountOpen) {
     accountService.createNewAccount(newAccountOpen);
    return ResponseEntity.ok("User is valid");
   
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
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
    
    
  
    
}
