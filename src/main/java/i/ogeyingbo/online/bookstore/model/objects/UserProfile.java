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

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UserProfile {
    
    private  int  id = -1;
    private String  username;
    private String  userPassword;
    private String  fullName;
    private String  mobile;
    private String  email;
    private BigDecimal  walletBalance =  new BigDecimal(0.00);
    private String  authPIN;
    private String  lastPurchaseDate;
    private String  lastPurchaseTime;
    
    
    public  void   setId(int inId){
        id = inId;
    }
    
    public  void   setUsername(String  inUsername){
        username = inUsername;
    }
    
    public  void   setUserPassword(String  inUserPassword){
        userPassword = inUserPassword;
    }
    
    public  void   setFullName(String  inFullName){
        fullName = inFullName;
    }
    
    public  void   setMobile(String  inMobile){
        mobile = inMobile;
    }
    
    public  void   setEmail(String  inEmail){
        email = inEmail;
    }
    
    public  void   setWalletBalance(BigDecimal   inWalletBalPlain){
        walletBalance = inWalletBalPlain;
    }
    
    
    public  void   setAuthPIN(String inAuthPIN){
        authPIN = inAuthPIN;
    }
    
    public  void   setLastPurchaseDate(String inLastPurchaseDate){
        lastPurchaseDate = inLastPurchaseDate;
    }
    
    public  void   setLastPurchaseTime(String inLastPurchaseTime){
       lastPurchaseTime = inLastPurchaseTime;
    }
    
    
    
    
    
    
    
      
    public  int   getId(){
        return    id;
    }
    
    public  String   getUsername(){
         return    username;
    }
    
    public  String   getUserPassword(){
         return    userPassword;
    }
    
    public  String   getFullName(){
         return    fullName;
    }
    
    public  String   getMobile(){
         return    mobile;
    }
    
    public  String   getEmail(){
         return    email;
    }
    
    public  BigDecimal   getWalletBalance(){
         return    walletBalance;
    }
    
    
    public  String   getAuthPIN(){
         return    authPIN;
    }
    
    public  String   getLastPurchaseDate(){
        return    lastPurchaseDate;
    }
    
    public  String   getLastPurchaseTime(){
       return    lastPurchaseTime;
    }
    
    
    
    
      
    public  static final  UserProfile  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        UserProfile   userProfile  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              userProfile = objectMapper.readValue(inObjectJSON, UserProfile.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  userProfile;
    }
     
     
     
     
    public  static final UserProfile  readFromJSON(String  inObjectJSON){ 
        UserProfile  userProfile  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              userProfile = objectMapper.readValue(inObjectJSON, UserProfile.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  userProfile;
    }
    
    
     
}
