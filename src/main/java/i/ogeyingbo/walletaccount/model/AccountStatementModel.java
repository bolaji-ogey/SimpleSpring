/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

import i.ogeyingbo.walletaccount.requests.AccountStatementReq;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Getter @Setter @NoArgsConstructor 
public class AccountStatementModel {
    
    
    private  String  accountNumber; 
    
    private String  startDate;
     
    private String  endDate;
    
    
    public  void  initAccountStatement(AccountStatementReq    inAccountStatementReq){
        
         accountNumber = inAccountStatementReq.getAccountNumber(); 
    
         startDate = inAccountStatementReq.getStartDate();
     
         endDate = inAccountStatementReq.getEndDate();
    
    }
    
}
