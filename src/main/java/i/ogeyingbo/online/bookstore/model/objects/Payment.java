/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.online.bookstore.model.objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Payment {
    
    private  int   userId =  -1;
    
    @NotBlank(message = "Title cannot be null or empty") @Pattern(regexp="[a-zA-Z0-9]")
    private  String  username;
    
    @NotBlank(message = "Title cannot be null or empty")
    private  String  password;
    
    @NotBlank(message = "Title cannot be null or empty") @Pattern(regexp="[0-9]")
    private  String  PIN;
    
    
    private  BigDecimal   totalAmount  =  new BigDecimal(0.00);
    
    
    
    public  void   setUsername(String  inUsername){
        username = inUsername;
    }
    
    public  void   setPassword(String  inPassword){
        password = inPassword;
    }
    
    
    public  void   setPIN(String  inPin){
        PIN = inPin;
    }
    
    
    public  void   setTotalAmount(BigDecimal   inTotalAmount){
        totalAmount = inTotalAmount;
    }
    
    
    
    
    
    
    public  String   getUsername(){
        return     username;
    }
    
    public  String   getPassword(){
        return    password;
    }
    
    
    public  String   getPIN(){
        return    PIN;
    }
    
    
    public  BigDecimal   getTotalAmount(){
        return    totalAmount;
    }
    
    
      
    public  static final Payment  readFromJSON(String  inObjectJSON){ 
        Payment  payment  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              payment = objectMapper.readValue(inObjectJSON, Payment.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  payment;
    }
    
    
    
}
