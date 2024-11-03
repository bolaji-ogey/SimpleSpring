/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

import i.ogeyingbo.walletaccount.requests.TrxnStatusQueryReq;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Getter @Setter @NoArgsConstructor  
public class TrxnStatusQueryModel {
    
    private  String  trxnReference;
    
    
    public  void   initTrxnStatusQuery(TrxnStatusQueryReq    inTrxnStatusQueryReq){
        
         trxnReference  =  inTrxnStatusQueryReq.getTrxnReference();
    }
    
}
