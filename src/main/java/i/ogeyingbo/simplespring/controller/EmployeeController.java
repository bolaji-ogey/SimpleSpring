/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.controller;

import i.ogeyingbo.simplespring.error.ErrorResponse;
import i.ogeyingbo.simplespring.model.Employee;
import i.ogeyingbo.simplespring.repository.ImageRepository;
import i.ogeyingbo.simplespring.service.MyService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
 @Autowired
 ImageRepository   imageRepository;
 
 @Autowired
 MyService  myService;
 
 

  @PostMapping
  public ResponseEntity<?> showRegistrationForm(@Valid @RequestBody Employee employee) {
  
    //TODO: Save the employee
    return ResponseEntity.ok(employee);
  }
  
  
   // Get EMployee Image
   @GetMapping(value = "/images/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    ByteArrayResource downloadImage(@PathVariable Long imageId) {
        byte[] image = imageRepository.findById(imageId)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
          .getImageData();

     return new ByteArrayResource(image);
    }


  
  
 @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
    
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
    }
    ErrorResponse error = new ErrorResponse("Validation Failed", details);
    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
  }
 
  
  
    
    
    
    public void someMethod() {

        Employee employee = new Employee(); // Create an Employee instance

        myService.createEmployee(employee)
          .subscribe(
            createdEmployee -> {
              // Handle the successful response
              System.out.println("Employee created: " + createdEmployee);
            },
            error -> {
              // Handle errors
              System.err.println("Error creating employee: " + error.getMessage());
            }
          );
      }

  
  
  
  
}