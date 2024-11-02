/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.dao;

import i.ogeyingbo.online.bookstore.model.objects.InventoryBook;
import i.ogeyingbo.online.bookstore.model.objects.ShoppingCartBook;
import i.ogeyingbo.online.bookstore.model.objects.UserProfile;
import i.ogeyingbo.online.bookstore.model.objects.UserPurchaseHistory;
import i.ogeyingbo.online.bookstore.model.objects.ShoppingCart;
import i.ogeyingbo.online.bookstore.model.objects.UserPurchase;
import i.ogeyingbo.walletaccount.model.AccountModel;
import i.ogeyingbo.walletaccount.model.AccountNameModel;
import i.ogeyingbo.walletaccount.model.AccountProfileModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PGAccountInterface {
    
   private   static  final   PGDataSource   pgDataSource  = PGDataSource.getInstance("bookinventory"); 
    
    private  static  PGAccountInterface   accountInterface; 
    
    
    public static  PGAccountInterface  getInstance()
    {
        if (accountInterface == null)
        {
            synchronized (PGAccountInterface.class)
            {
                accountInterface = new PGAccountInterface();
            } 
        }
        return   accountInterface;
    }
    
    
    
    
     
     
   
    
    private   PGAccountInterface(){}
    
     
    
    public  static  void  main(String[]  args){ 
        //System.out.println(""+PGDataRetriever.convertDateOfBirth("04/13/2023"));
    }
    
     
        
  
  
    
    public    int     blockAccount(String  inAccntNo, String inReason){
          
          StringBuilder   updateQuery;
           PreparedStatement    prepStmnt =    null; 
           int   resultCount  =  0;
           Connection  cron   = null;
            
           try { 
                
                 updateQuery  =  new  StringBuilder(150);
                updateQuery.append(" UPDATE   wallet_account   SET   is_active = false,  ");
                updateQuery.append(" status_reason  = ?  WHERE  account_number  = ?  ");  
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(updateQuery.toString());
                 
                prepStmnt.setString(1, inReason);
                prepStmnt.setString(2, inAccntNo); 
                        
                resultCount = prepStmnt.executeUpdate();
                           
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               updateQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                     
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   resultCount;
       }
  
     
      
    public    int     unBlockAccount(String  inAccntNo, String inReason){
          
          StringBuilder   updateQuery;
           PreparedStatement    prepStmnt =    null; 
           int   resultCount  =  0;
           Connection  cron   = null;
            
           try { 
                
                 updateQuery  =  new  StringBuilder(150);
                updateQuery.append(" UPDATE   wallet_account   SET   is_active = true,  ");
                updateQuery.append(" status_reason  = ?  WHERE  account_number  = ?  ");  
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(updateQuery.toString());
                 
                prepStmnt.setString(1, inReason);
                prepStmnt.setString(2, inAccntNo); 
                        
                resultCount = prepStmnt.executeUpdate();
                           
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               updateQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                     
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   resultCount;
       }
  
      
     public     AccountModel    findByAccountNo(String  inAccountNo){
          
           PreparedStatement    prepStmnt =    null; 
           ResultSet row = null; 
           Connection  cron   = null;
           AccountModel   accountModel = null;
             
           try { 
                   
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement("SELECT  account_number, account_name  FROM  wallet_account  WHERE  account_number = ? ");
                prepStmnt.setString(1, inAccountNo);
                row = prepStmnt.executeQuery();
                  
                    // Parameters start with 1
                    while (row.next()) {

                        accountModel  =  new  AccountModel();
                        
                        accountModel.setAccountNumber(row.getString("account_number"));
                        accountModel.setAccountName(row.getString("account_name")); 
                         
                    } 
                  
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   accountModel;
       }
     
      
    
     public     AccountModel    getAccountDetail(String  inAccountNo){
          
           PreparedStatement    prepStmnt =    null; 
           ResultSet row = null; 
           Connection  cron   = null;
           AccountModel   accountModel = null;
           StringBuilder   sbQuery  =  new StringBuilder(250);
             
           try { 
                   
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                sbQuery.append("SELECT  account_number, account_name  "); 
                sbQuery.append("FROM  wallet_account  WHERE  account_number = ? ");
                
                prepStmnt =    cron.prepareStatement(sbQuery.toString());
                prepStmnt.setString(1, inAccountNo);
                row = prepStmnt.executeQuery();
                  
                    // Parameters start with 1
                    while (row.next()) {

                        accountModel  =  new  AccountModel();
                        
                        accountModel.setAccountNumber(row.getString("account_number"));
                        accountModel.setAccountName(row.getString("account_name")); 
                         
                    } 
                  
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   accountModel;
       }
     
     
     
     
     
       public     AccountNameModel    getAccountNumberAndProfileName(String  inCustomerReference){
          
           PreparedStatement    prepStmnt =    null; 
           ResultSet row = null; 
           Connection  cron   = null;
           AccountNameModel   accountNameModel = null;
           StringBuilder   sbQuery  =  new StringBuilder(250);
             
           try { 
                   
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                sbQuery.append("SELECT  ap.first_name, ap.middle_name, ap.last_name, wa.account_number, wa.account_name  "); 
                sbQuery.append(" FROM   account_profile  ap  join   wallet_account  wa "); 
                sbQuery.append(" ON (wa.customer_reference  =  ap.customer_reference) "); 
                sbQuery.append("  WHERE  ap.customer_reference = ? ");
                
                prepStmnt =    cron.prepareStatement(sbQuery.toString());
                prepStmnt.setString(1, inCustomerReference);
                row = prepStmnt.executeQuery();
                  
                    // Parameters start with 1
                    while (row.next()) {

                        accountNameModel  =  new  AccountNameModel();
                        
                        accountNameModel.setFirstName(row.getString("first_name"));
                        accountNameModel.setMiddleName(row.getString("middle_name"));                         
                        accountNameModel.setLastName(row.getString("last_name"));
                        
                        accountNameModel.setAccountNumber(row.getString("account_number"));                          
                        accountNameModel.setAccountName(row.getString("account_name")); 
                         
                    } 
                  
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   accountNameModel;
       }
     
       
       
       
       
     
     public    int     updateAccountProfile(AccountProfileModel   inAccountProfileModel){
          
          StringBuilder   updateQuery;
           PreparedStatement    prepStmnt =    null; 
           int   resultCount  =  0;
           Connection  cron   = null;
           String subQuery  =  "";
           String  updateValue =  "";
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("lastName")){
               subQuery =  " SET  last_name =  ? ";
               updateValue =  inAccountProfileModel.getLastName();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("dateOfBirth")){
               subQuery =  " SET  date_of_birth =  ? ";
               updateValue =  inAccountProfileModel.getDateOfBirth();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("email")){
               subQuery =  " SET  email =  ? ";
               updateValue =  inAccountProfileModel.getEmail();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("phoneNumber")){
               subQuery =  " SET  phone_number =  ? ";
               updateValue =  inAccountProfileModel.getPhoneNumber();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("address")){
               subQuery =  " SET  address  =  ? ";
               updateValue =  inAccountProfileModel.getAddress();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("location")){
               subQuery =  " SET  location =  ? ";
               updateValue =  inAccountProfileModel.getLocation();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("state")){
               subQuery =  " SET  state =  ? ";
               updateValue =  inAccountProfileModel.getState();
           }
           
           if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("country")){
               subQuery =  " SET  country =  ? ";
               updateValue =  inAccountProfileModel.getCountry();
           }
               
            
           try { 
                
                 updateQuery  =  new  StringBuilder(150);
                updateQuery.append(" UPDATE    account_profile  ").append(subQuery);  
                updateQuery.append("  WHERE  customer_reference  = ?  ");  
                              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(updateQuery.toString());
                 
                prepStmnt.setString(1, updateValue);
                prepStmnt.setString(2, inAccountProfileModel.getCustomerReference()); 
                        
                resultCount = prepStmnt.executeUpdate();
                
                AccountNameModel   accountNameModel  =  getAccountNumberAndProfileName(inAccountProfileModel.getCustomerReference());
                
                
                if(inAccountProfileModel.getDataToUpdate().equalsIgnoreCase("lastName")){
                    prepStmnt =    cron.prepareStatement("UPDATE  wallet_account  SET  account_name  = ?  WHERE  account_number = ? ");
                    
                    prepStmnt.setString(1, accountNameModel.getNewAccountName());
                    prepStmnt.setString(2, inAccountProfileModel.getCustomerReference()); 

                    resultCount = prepStmnt.executeUpdate();
                }
                           
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               updateQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                     
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   resultCount;
       }
     
     
     
     
      
      public     AccountProfileModel    getAccountProfileDetail(String  inCustomerReference){
          
           PreparedStatement    prepStmnt =    null; 
           ResultSet row = null; 
           Connection  cron   = null;
           AccountProfileModel   accountProfileModel = null;
           StringBuilder   sbQuery  =  new StringBuilder(250);
             
           try {  
                   
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                sbQuery.append("SELECT  customer_reference,  first_name, middle_name, last_name, bvn,  ");
                sbQuery.append(" email, phone_number, date_of_birth,  address, location, state, country  ");
                sbQuery.append("FROM   account_profile  WHERE  customer_reference = ? ");
                
                prepStmnt =    cron.prepareStatement(sbQuery.toString());
                prepStmnt.setString(1, inCustomerReference);
                row = prepStmnt.executeQuery();
                  
                    // Parameters start with 1
                    while (row.next()) {

                        accountProfileModel  =  new  AccountProfileModel();
                        
                        accountProfileModel.setCustomerReference(row.getString("customer_reference"));
                        accountProfileModel.setFirstName(row.getString("first_name")); 
                        accountProfileModel.setMiddleName(row.getString("middle_name")); 
                        accountProfileModel.setLastName(row.getString("last_name")); 
                        accountProfileModel.setBvn(row.getString("bvn")); 
                        accountProfileModel.setEmail(row.getString("email")); 
                        accountProfileModel.setPhoneNumber(row.getString("phone_number")); 
                        
                        accountProfileModel.setDateOfBirth(row.getString("date_of_birth")); 
                        accountProfileModel.setAddress(row.getString("address")); 
                        accountProfileModel.setLocation(row.getString("location"));
                        accountProfileModel.setState(row.getString("state")); 
                        accountProfileModel.setCountry(row.getString("country"));
                         
                    } 
                  
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   accountProfileModel;
       }
     
     
     
     
    
  public     ArrayList<InventoryBook>    getBookInventory(){
          
           Statement     stmnt =    null; 
           ResultSet row = null;
           ArrayList<InventoryBook>  inventoryBookList =  new   ArrayList<>(); 
           Connection  cron   = null;
           
            
           try { 
               
                
     
                StringBuilder    selectQuery  =  new  StringBuilder(200);
                selectQuery.append(" SELECT  book_inventory.id as id,  book_inventory.title as title,   ");
                selectQuery.append(" book_inventory.genre as genre,  book_inventory.isbn as isbn,  ");
                selectQuery.append(" book_inventory.author as author,  book_inventory.year_published as year_published,  ");
                selectQuery.append("  book_prices.price as price,  book_prices.units_in_stock as  units_in_stock "); 
                selectQuery.append("  FROM  book_inventory  JOIN  book_prices  ");
                selectQuery.append("  ON  (book_prices.book_id  =  book_inventory.id) ");
 
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                stmnt =    cron.createStatement();
              
                row = stmnt.executeQuery(selectQuery.toString());
                  
                        // Parameters start with 1
                        while (row.next()) {

                             InventoryBook   inventoryBook  =  new  InventoryBook();
                        
                            inventoryBook.setId( row.getInt("id")); 
                            inventoryBook.setTitle(row.getString("title").trim());
                            inventoryBook.setGenre(row.getString("genre").trim());
                            inventoryBook.setIsbn(row.getString("isbn").trim());
                            inventoryBook.setAuthor(row.getString("author").trim());
                            inventoryBook.setYearPublished(row.getString("year_published").trim()); 
                            inventoryBook.setPrice(row.getBigDecimal("price"));
                            inventoryBook.setUnitsInStock( row.getInt("units_in_stock"));

                           inventoryBookList.add(inventoryBook);

                        } 
                      
                  System.out.println("Inventory Books >>>> "+inventoryBookList.size());
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               //selectQuery = null;
                 try{
                     if(stmnt !=  null){
                        stmnt.cancel();
                        stmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   inventoryBookList;
       }
     
  
  
       
   public     ShoppingCart    getShoppingCart(String  inOrderId){
          
           PreparedStatement    prepStmnt =    null; 
           ResultSet row = null;
           ShoppingCart   shoppingCart =   new ShoppingCart();  
           Connection  cron   = null;
             
           try { 
                   
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement("SELECT * FROM  shopping_cart_books  WHERE  order_serial = ? ");
                prepStmnt.setString(1, inOrderId);
                row = prepStmnt.executeQuery();
                  
                    // Parameters start with 1
                    while (row.next()) {

                        ShoppingCartBook   shoppingCartBook  =  new  ShoppingCartBook();
                        
                        shoppingCartBook.setId(row.getInt("id"));
                        shoppingCartBook.setOrderSerial(row.getString("order_serial").trim());
                        shoppingCartBook.setTitle(row.getString("title").trim());
                        shoppingCartBook.setGenre(row.getString("genre").trim());
                        shoppingCartBook.setIsbn(row.getString("isbn").trim());
                        shoppingCartBook.setAuthor(row.getString("author").trim());
                        shoppingCartBook.setYearPublished(row.getString("year_published").trim());
                        shoppingCartBook.setPrice(row.getBigDecimal("price"));
                        
                        shoppingCart.add(shoppingCartBook);
                    } 
                 
                    System.out.println("Shopping Cart >>>> "+shoppingCart.size());
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   shoppingCart;
       }
     
   
   
    
   public      UserPurchaseHistory     getUserPurchaseHistory(int  userId) {
        
          StringBuilder   sbQuery = new StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           ResultSet row = null;
           UserPurchaseHistory   userPurchaseHistory =   new UserPurchaseHistory(); 
           Connection  cron   = null;
            
           try { 
                
               String  ph_query =  " SELECT * FROM  user_purchase_history  WHERE user_id = ?   "; 
              
                 cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement(ph_query);
                prepStmnt.setInt(1, userId);
                row = prepStmnt.executeQuery();
                   
                    while (row.next()) {

                      UserPurchase  userPurchase  =  new  UserPurchase();
                        
                        userPurchase.setId(row.getInt("id"));
                        userPurchase.setOrderSerial(row.getString("order_serial").trim());
                        userPurchase.setTitle(row.getString("title").trim());
                        userPurchase.setGenre(row.getString("genre").trim());
                        userPurchase.setIsbn(row.getString("isbn").trim());
                        userPurchase.setAuthor(row.getString("author").trim());
                        userPurchase.setYearPublished(row.getString("year_published").trim());
                        userPurchase.setUserId( row.getInt("user_id"));
                        userPurchase.setUserName(row.getString("user_name").trim());
                        userPurchase.setUserPhoneNumber(row.getString("user_phone_number").trim());
                        userPurchase.setPurchasePrice(row.getBigDecimal("purchase_price"));
                        userPurchase.setPurchaseDate(row.getString("purchase_date").trim());
                        userPurchase.setPurchaseTime(row.getString("purchase_time").trim());
                 
                       userPurchaseHistory.add(userPurchase);
                    } 
                    
                    System.out.println("User Purchases >>>> "+userPurchaseHistory.size());
                  
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   userPurchaseHistory;
       }
     
            
            
    public     ArrayList<UserProfile>    getUserProfiles(){
         
          Statement    stmnt =    null; 
           ResultSet row = null;
           ArrayList<UserProfile>   userProfileList =   new ArrayList<>();
            Connection  cron   =  null;
            
           try { 
                
                String  up_query =  " SELECT   * FROM  user_profile  ";  
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                stmnt =    cron.createStatement();
                                  
                row = stmnt.executeQuery(up_query);
                  
                // Parameters start with 1
                while (row.next()) {
                    
                      UserProfile   userProfile  =  new  UserProfile();
                      
                        userProfile.setId( row.getInt("id"));
                        userProfile.setUsername(row.getString("username").trim());
                        userProfile.setUserPassword(row.getString("user_password").trim());
                        userProfile.setFullName(row.getString("full_name").trim());
                        userProfile.setMobile(row.getString("mobile").trim());
                        userProfile.setEmail(row.getString("email").trim());
                        userProfile.setWalletBalance(row.getBigDecimal("wallet_balance"));
                        userProfile.setAuthPIN(row.getString("uath_pin").trim());
                        userProfile.setLastPurchaseDate(row.getString("last_purchase_date").trim());
                        userProfile.setLastPurchaseTime(row.getString("last_purchase_time").trim()); 
                        
                        userProfileList.add(userProfile);
                } 
                 
                System.out.println("User Profiles >>>> "+userProfileList.size());
                //custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(stmnt !=  null){
                        stmnt.cancel();
                        stmnt.close();
                    }
                    
                    if(row != null){
                        row.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   userProfileList;
       }
     
     
  
  
         
  public    int     makePayment(String  userName, String inPassword,  String PIN,  BigDecimal  inTotalAmount,
                                            String  extTransactionRef){
         
           StringBuilder   sbQuery = new StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           int   resultCount  =  0;
           Connection  cron   = null;
           
            
           try { 
                
                StringBuilder   updateQuery  =  new  StringBuilder(200);
                updateQuery.append(" UPDATE   user_profile   SET  wallet_balance  =   wallet_balance  -  ? ");
                updateQuery.append(" WHERE  username = ?  AND  user_password   = ?   AND  wallet_balance >=  ?  ");  
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(updateQuery.toString());
                
                prepStmnt.setBigDecimal(1, inTotalAmount);
                prepStmnt.setString(2, userName);
                prepStmnt.setString(3, inPassword);
                prepStmnt.setBigDecimal(4, inTotalAmount);
                        
                resultCount = prepStmnt.executeUpdate();
                           
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                     
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   resultCount;
       }
  
  
  
  
  
  
  
  
public    int     updateSessionKey(String  inIPAddress,  String  inOldRequestKey,  
                                                          long  currentTime,   String  inNewRequestKey){
         
           StringBuilder   sbQuery = new StringBuilder(150);
           StringBuilder   updateQuery  =  new  StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           PreparedStatement    prepStmnt2 =    null; 
           int   resultCount  =  0;
           int   resultCount2  =  0;
           Connection  cron   = null;
           
            
           try { 
                
                
                updateQuery.append(" UPDATE   user_sessions   SET   new_request_key  =   ?,  ");
                updateQuery.append(" WHERE  ip_address = ?  AND  old_request_key   = ?    ");  
                updateQuery.append(" AND  expiry_time <=  ?   ");  
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(updateQuery.toString());
                
                prepStmnt.setString(1, inNewRequestKey);
                prepStmnt.setString(2, inIPAddress); 
                prepStmnt.setString(3, inOldRequestKey);                
                prepStmnt.setLong(4, currentTime);
                        
                resultCount = prepStmnt.executeUpdate();
                
                
                sbQuery.append("UPDAE  user_sessions SET  old_request_key  =  new_request_key, ");
                sbQuery.append(" expiry_time  =  ?    WHERE  ip_address   = ?    ");
                prepStmnt2 =    cron.prepareStatement(sbQuery.toString());
                
                prepStmnt2.setLong(1, currentTime + 3600000L);               
                prepStmnt2.setString(2, inIPAddress); 
                        
                resultCount2 = prepStmnt2.executeUpdate();
                           
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               updateQuery = null;
               sbQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                     
                    if(prepStmnt2 !=  null){
                        prepStmnt2.cancel();
                        prepStmnt2.close();
                    }
                     
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   resultCount;
       }
  
  
  
  
  
  
  
 public    int     initializeSession(String  inIPAddress,  String  inRequestKey, String  inProfileTypeCode,
                                               String  inCustomerRef,   String inPartnerCode,  long inCurrentTime,
                                                   String  inSchemeCode,  String inRequestChannel,  String  inRequestUserType){
         
           StringBuilder   updateQuery1 = new StringBuilder(200);
           StringBuilder   updateQuery = new StringBuilder(200);
           PreparedStatement    prepStmnt1 =    null;
           PreparedStatement    prepStmnt =    null; 
           int   resultCount  =  0;
           Connection  cron   = null;
           
            
           try { 
               
               
                updateQuery.append(" UPDATE   user_sessions  SET   ip_address = ?,  old_request_key  = ?,  ");
                updateQuery.append("  expiry_time = ?  WHERE   customer_ref  = ?    ");  
                updateQuery.append("    AND  scheme_code  = ?  AND  partner_code  = ?");  
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt1 =    cron.prepareStatement(updateQuery1.toString());
                
                prepStmnt1.setString(1, inIPAddress);
                prepStmnt1.setString(2, inRequestKey); 
                prepStmnt1.setLong(3, inCurrentTime + 3600000L);
                prepStmnt1.setString(4, inCustomerRef); 
                prepStmnt1.setString(5, inSchemeCode); 
                prepStmnt1.setString(6, inPartnerCode);  
                
                
                        
                resultCount = prepStmnt1.executeUpdate();
                
                
                if(resultCount == 0){
                    
                    updateQuery.append(" INSERT INTO   user_sessions  (ip_address,  profile_type_code, "); 
                    updateQuery.append(" customer_ref, partner_code,  scheme_code,  request_user_type, "); 
                    updateQuery.append(" request_channel, old_request_key, expiry_time, is_active_session,  "); 
                    updateQuery.append(" last_login_date,  last_login_time) ");
                    updateQuery.append(" values (?,?,?,?,?,?,?,?,?,?, current_date, current_time) "); 

                    System.out.println("cron = "+cron);

                    prepStmnt =    cron.prepareStatement(updateQuery.toString());

                    prepStmnt.setString(1, inIPAddress);
                    prepStmnt.setString(2, inProfileTypeCode);
                    prepStmnt.setString(3, inCustomerRef);
                    prepStmnt.setString(4, inPartnerCode);
                    prepStmnt.setString(5, inSchemeCode);
                    prepStmnt.setString(6, inRequestUserType);
                    prepStmnt.setString(7, inRequestChannel);
                    prepStmnt.setString(8, inRequestKey);
                    prepStmnt.setLong(9, inCurrentTime + 3600000L);
                    prepStmnt.setBoolean(10, true);  

                    resultCount = prepStmnt.executeUpdate();
                
                }
                           
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                 
                e.printStackTrace();
            }  finally{ 
               updateQuery = null;
               updateQuery1 = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                     
                      if(prepStmnt1 !=  null){
                        prepStmnt1.cancel();
                        prepStmnt1.close();
                    }
                     
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            } 
           return   resultCount;
       }
  
  
  
  
  
  
              
}
