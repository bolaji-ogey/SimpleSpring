/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.online.bookstore.model.objects;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ShoppingCart  extends   ArrayList<ShoppingCartBook> {
    
    
    private  String  orderSerial;
    
    
    private  BigDecimal   totalPrice  = new BigDecimal(0.00);
    
    
    private  int   numberOfBooksInCart  =  0;
    
    private  boolean   paymentProcessed  = false;
      


    
            
    public  boolean   clearCart(){
        
        return false;
    }
    
    public  boolean   addBook(ShoppingCartBook    newShoppingCartBook){
        newShoppingCartBook.includeInCart();
        this.add(newShoppingCartBook);
        return true;
    }
    
    public  boolean   checkOut(){
        
        return false;
    }
    
    
    
    
    
    
    
       
      
    public  static final  ShoppingCart  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ShoppingCart   shoppingCart  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              shoppingCart = objectMapper.readValue(inObjectJSON, ShoppingCart.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  shoppingCart;
    }
     
     
     
     
    public  static final  ShoppingCart  readFromJSON(String  inObjectJSON){ 
        ShoppingCart  shoppingCart  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              shoppingCart = objectMapper.readValue(inObjectJSON, ShoppingCart.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  shoppingCart;
    }
    
    
    
    
    
}
