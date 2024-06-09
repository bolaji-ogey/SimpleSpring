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
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Connection;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ShoppingCartBook  extends Book {
    
    private  int   id  =  0;
    
    @Size(min=1, max=20)
    @NotBlank(message="Cannot be null or empty")
    private  String  orderSerial;
    
    @NotBlank(message = "Add or Remove command be null or empty") 
    @Pattern(regexp="[+-]")
    @Size(min=1, max=1)
    private  String  addOrRemove;
    
    private  BigDecimal  price = new  BigDecimal(0.00);
    
    private boolean  paymentProcessed = false;
    
    
    public  void   includeInCart(){
        addOrRemove = "+";
    }
    
    public  void   removeFromCart(){
        addOrRemove = "-";
    }
    
    
    public  void  setId(int  inId){
        id = inId;
    }
    
    public  void  setOrderSerial(String  inOrderSerial){
        orderSerial  = inOrderSerial;
    }
    
    
    public  void  setAddOrRemove(String  inAddOrRemove){
        addOrRemove =  inAddOrRemove;
    }
    
    public  void  setPrice(BigDecimal  inPrice){
        price  = inPrice;
    }
    
    
    public  void  setPaymentProcessed(boolean  inPaymentProcessed){
        paymentProcessed   =  inPaymentProcessed;
    }
    
    
    
    
    
    public  int  getId(){
       return    id;
    }
    
    public  String  getOrderSerial(){
       return    orderSerial;
    }
    
    
    public  String  getAddOrRemove(){
       return    addOrRemove;
    }
    
    public  BigDecimal  getPrice(){
       return    price;
    }
    
    
    public  boolean  getPaymentProcessed(){
       return    paymentProcessed;
    }
    
    
    
      
    public  static final  ShoppingCartBook  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ShoppingCartBook   shoppingCartBook  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              shoppingCartBook = objectMapper.readValue(inObjectJSON, ShoppingCartBook.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  shoppingCartBook;
    }
     
     
     
     
    public  static final ShoppingCartBook  readFromJSON(String  inObjectJSON){ 
        ShoppingCartBook  shoppingCartBook  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              shoppingCartBook = objectMapper.readValue(inObjectJSON, ShoppingCartBook.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  shoppingCartBook;
    }
    
    
    
}
