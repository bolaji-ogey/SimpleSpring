/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import i.ogeyingbo.walletaccount.requests.FundTransferReq;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Getter @Setter @NoArgsConstructor 
public class FundTransferModel {
    
     
    private  String  sourceAccount;
     
    private String  trxnReference;
     
    private  BigDecimal  trxnAmount =  new BigDecimal(0.00);
     
    private String  beneficiaryAccount;
     
      
    private String  beneficiaryAccountName;
      
    private String  beneficiaryBankCode;
    
    private  int  PIN;
     
    private String  narration;
    
    
    
    
    
    public  void   initFundTransfer(FundTransferReq  inFundTransferReq){
        
        sourceAccount =  inFundTransferReq.getSourceAccount();
     
        trxnReference = inFundTransferReq.getTrxnReference();

        trxnAmount =   inFundTransferReq.getTrxnAmount();

        beneficiaryAccount = inFundTransferReq.getBeneficiaryAccount();


        beneficiaryAccountName = inFundTransferReq.getBeneficiaryAccountName();

        beneficiaryBankCode = inFundTransferReq.getBeneficiaryBankCode();
        
        PIN   =   inFundTransferReq.getPIN();

        narration = inFundTransferReq.getNarration();
    
    }
    
    
    
    
}
