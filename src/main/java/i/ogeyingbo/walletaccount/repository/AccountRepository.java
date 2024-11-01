/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.repository;
 
import i.ogeyingbo.walletaccount.entities.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public interface AccountRepository   extends JpaRepository<Account, Long> {
    
    Optional<Account>   findByAccountNumber(String accountNumber);
    
    
}