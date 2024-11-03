 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.entities;
 
import i.ogeyingbo.walletaccount.requests.OpenAccountReq;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet_account")
public class  Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "request_id") 
    private  String  requestId;

    @Column(name = "customer_reference") 
    private  String  customerReference;
    
    @Column(name = "account_number") 
    private String  accountNumber;
    
    @Column(name = "account_name") 
    private String  accountName;
    
    @Column(name = "bank_code") 
    private String  bankCode;
     
    
    @Column(name = "bvn") 
    private String  bvn;
    
    @Size(min = 3, max = 6)
    @Column(name = "product_code") 
    private String  productCode;
    
    @Column(name = "is_active") 
    private  boolean  isActive = true;
    
     
    
    @Column(name = "date_opened") 
    private String  dateOpened;
    
    
    @Column(name = "last_trxn_date") 
    private String  lastTrxnDate;
    
    @Column(name = "last_credit_date") 
    private String  lastCreditDate;
    
    
    @Column(name = "last_debit_date")  
    private String  lastDebitDate;
    
      
    
    
    
    public  void  initAccount(OpenAccountReq   inOpenAccountReq){
        
        StringBuilder  acctName  =  new  StringBuilder(100);
        acctName.append(inOpenAccountReq.getFirstName()).append(" ");
        acctName.append(inOpenAccountReq.getMiddleName()).append(" ");
        acctName.append(inOpenAccountReq.getLastName()).append(" ");
        
        customerReference  =  inOpenAccountReq.getCustomerReference();
        accountName  =  acctName.toString();         
        bvn  =  inOpenAccountReq.getBvn();  
        productCode  =  inOpenAccountReq.getProductCode(); 
        isActive  =  true;
    }
    
    
    
    
}

