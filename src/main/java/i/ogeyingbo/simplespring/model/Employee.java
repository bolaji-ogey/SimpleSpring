/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Connection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor; 
import org.hibernate.validator.constraints.Email;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
//@Data
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
    
    public  void  setEmail(String inEmail){
        email = inEmail;
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
    
    public  String  getEmail(){
        return    email;
    }
    
    
    
    
        
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
     
     
    public  static final  Employee  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        Employee   employee  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              employee = objectMapper.readValue(inObjectJSON, Employee.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  employee;
    }
     
     
     
     
    public  static final Employee  readFromJSON(String  inObjectJSON){ 
        Employee  employee  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              employee = objectMapper.readValue(inObjectJSON, Employee.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  employee;
    }
    
    
    
    
    
    
}
