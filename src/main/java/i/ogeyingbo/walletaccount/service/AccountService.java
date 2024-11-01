/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.service;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j; 
import i.ogeyingbo.walletaccount.entities.Account;
import i.ogeyingbo.walletaccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Service
@Slf4j
public class AccountService {
    
  @Autowired
  private  AccountRepository    accountRepository;

  public void save(Account  account) {
    try { 
      accountRepository.save(account);
    } catch (Exception e) {
     // log.debug("Some internal error occurred", e);
    }
  }

  /**
  public List<Profile> getAll() {
    return profileRepository.findAll();
  }
**/
  
  
  public Optional<Account> findByAccountNumber(String  accountNumber) {
    return    accountRepository.findByAccountNumber(accountNumber);
  }
  
  
  
  
    
}
