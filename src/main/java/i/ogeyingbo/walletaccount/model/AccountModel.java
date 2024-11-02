/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;
 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Getter @Setter @NoArgsConstructor 
public class AccountModel {
     
    private long id;
 
    private  String  customerReference;
     
    private String  accountNumber;
     
    private String  accountName;
     
    private String  bankCode;
     
     
    private String  bvn;
     
    private  boolean  isActive = true;
    
 
    private String  dateOpened;
    
     
    private String  lastTrxnDate;
     
    private String  lastCreditDate;
    
      
    private String  last_debit_date;
    
      
    
    
}
