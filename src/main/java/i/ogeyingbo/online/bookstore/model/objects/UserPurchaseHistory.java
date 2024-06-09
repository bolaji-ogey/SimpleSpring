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
public class UserPurchaseHistory   extends  ArrayList<UserPurchase>  {
     
    
    
      
    public  static final  UserPurchaseHistory  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        UserPurchaseHistory   userPurchaseHistory  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              userPurchaseHistory = objectMapper.readValue(inObjectJSON, UserPurchaseHistory.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  userPurchaseHistory;
    }
     
     
     
     
    public  static final UserPurchaseHistory  readFromJSON(String  inObjectJSON){ 
        UserPurchaseHistory  userPurchaseHistory  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              userPurchaseHistory = objectMapper.readValue(inObjectJSON, UserPurchaseHistory.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  userPurchaseHistory;
    }
    
    
    
    
}
