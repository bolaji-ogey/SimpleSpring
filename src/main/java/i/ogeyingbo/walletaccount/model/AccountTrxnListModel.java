/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

import i.ogeyingbo.walletaccount.requests.AccountTrxnListReq;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Getter @Setter @NoArgsConstructor  
public class AccountTrxnListModel {
     
    private  String  accountNumber;
     
    private String  startDate;
     
    private String  endDate;
     
    private String  transactionType;
    
    
    public  void  initAccountTrxnList(AccountTrxnListReq    inAccountTrxnListReq){
        
         accountNumber = inAccountTrxnListReq.getAccountNumber();
     
         startDate = inAccountTrxnListReq.getStartDate();

         endDate = inAccountTrxnListReq.getEndDate();

         transactionType = inAccountTrxnListReq.getTransactionType();
        
        
    }
    
}
