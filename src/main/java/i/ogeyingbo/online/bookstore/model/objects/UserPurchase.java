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
public class UserPurchase {
    
    private  int  id = -1;
    private String  orderSerial;
    private String  title;
    private String  genre;
    private String  isbn;
    private String  author;
    private String  yearPublished;
    private  int  userIid = -1;
    private String  userName;
    private String  userPhoneNumber;
    private BigDecimal  purchasePrice = new BigDecimal(0.00);
    private String  purchaseDate;
    private String  purchaseTime; 
    
    
    
    public   void   setId(int inId){
        id =  inId;
    }
    
    public   void   setOrderSerial(String inOrderSerial){
        orderSerial =  inOrderSerial;
    }
    
    public   void   setTitle(String inTitle){
        title =  inTitle;
    }
    
    public   void   setGenre(String inGenre){
        genre =  inGenre;
    }
    
    public   void   setIsbn(String inIsbn){
        isbn =  inIsbn;
    }
    
    public   void   setAuthor(String inAuthor){
        author =  inAuthor;
    }
    
    public   void   setYearPublished(String inYearPublished){
        yearPublished =  inYearPublished;
    }
    
    public   void   setUserId(int inUserId){
        userIid =  inUserId;
    }
    
    public   void   setUserName(String inUserName){
        userName =  inUserName;
    }
    
    public   void   setUserPhoneNumber(String   inUserPhoneNumber){
        userPhoneNumber =  inUserPhoneNumber;
    }
    
    public   void   setPurchasePrice(BigDecimal inPurchasePrice){
        purchasePrice =  inPurchasePrice;
    }
     
    
    public   void   setPurchaseDate(String   inPurchaseDate){
        purchaseDate =  inPurchaseDate;
    }
    
    public   void   setPurchaseTime(String   inPurchaseTime){
        purchaseTime =  inPurchaseTime;
    }
    
    
    
      
    public  static final  UserPurchase  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        UserPurchase   userPurchase  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              userPurchase = objectMapper.readValue(inObjectJSON, UserPurchase.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  userPurchase;
    }
     
     
     
     
    public  static final UserPurchase  readFromJSON(String  inObjectJSON){ 
        UserPurchase  userPurchase  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              userPurchase= objectMapper.readValue(inObjectJSON, UserPurchase.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  userPurchase;
    }
    
    
    
    
}
