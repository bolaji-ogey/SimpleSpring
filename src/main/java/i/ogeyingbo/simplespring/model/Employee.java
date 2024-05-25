/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Builder.Default  private  int  id = -1;
    
    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 20, message = "First name should be between 3 and 20 characters")
    private String  firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private String  lastName;
    
    @NotBlank(message = "Address is required") 
    private String  address;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    String email;
    
    /***
    public  void  setId(int inId){
        id = inId;
    }
    
    
    public  void  setFirstName(String inFirstName){
        firstName = inFirstName;
    }
    
    public  void  setLastName(String inLastName){
        lastName = inLastName;
    }
    
    
    public  void  setAddress(String inAddress){
        address = inAddress;
    }
    
    
    
    
     public  int  getId(){
        return   id;
    }
    
    
    public  String  getFirstName(){
        return    firstName;
    }
    
    public  String  getLastName(){
        return    lastName;
    }
    
    
    public  String  getAddress(){
        return    address;
    }
    
    ***/
    
}
