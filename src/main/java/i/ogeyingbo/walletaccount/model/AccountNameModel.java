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
public class AccountNameModel {
    
    private  String  customerReference;
     
    private String  firstName;
     
    private String  middleName;
     
    private String  lastName;
    
    private String  accountNumber;
     
    private String  accountName;
    
    
    
    public  String  getNewAccountName(){
        StringBuilder   newAccountName  =  new StringBuilder(130);
            newAccountName.append(firstName).append(" ").append(middleName);
            newAccountName.append(" ").append(lastName);
        return   newAccountName.toString();
    }
     
    
    
   
    
}
