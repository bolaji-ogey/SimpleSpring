/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package i.ogeyingbo.walletaccount.repository;

import i.ogeyingbo.walletaccount.entities.Account;
import i.ogeyingbo.walletaccount.entities.AccountProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public interface AccountProfileRepository  extends JpaRepository<AccountProfile, Long> {
    
   // Optional<AccountProfile>   findByAccountNumber(String accountNumber);
    
}
