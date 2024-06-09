/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.online.bookstore.model.objects;

 
import java.math.BigDecimal;
import java.sql.Connection;
//import org.hibernate.validator.internal.properties.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class InventoryBook  extends Book  {
    
    private  int   id  =  0;
    
    private   BigDecimal  price    =  new  BigDecimal(0.00);
    
    private  int   unitsInStock  =  0;
    
    
    public   void  setId(int  inId){
        id = inId;
    }
    
    
    public   void  setPrice(BigDecimal   inPrice){
        price = inPrice;
    }
    
    
    public   void  setUnitsInStock(int  inUnitsInStock){
        unitsInStock  = inUnitsInStock;
    }
    
    
    
    
    public   int  getId(){
       return   id;
    }
    
    
    public   BigDecimal  getPrice(){
       return    price;
    }
    
    
    public   int  getUnitsInStock(){
       return    unitsInStock;
    }
    
    
    
    
      
    public  static final  InventoryBook  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        InventoryBook   inventoryBook  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              inventoryBook = objectMapper.readValue(inObjectJSON, InventoryBook.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  inventoryBook;
    }
     
     
     
     
    public  static final InventoryBook  readFromJSON(String  inObjectJSON){ 
        InventoryBook  inventoryBook  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              inventoryBook = objectMapper.readValue(inObjectJSON, InventoryBook.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  inventoryBook;
    }
    
    
    
    
    
}
