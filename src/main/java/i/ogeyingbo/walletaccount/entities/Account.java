 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.entities;
 
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
@Table(name = "wallet_accounts")
public class  Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_reference") 
    private  String  customerReference;
    
    @Column(name = "first_name") 
    private String  firstName;
    
    @Column(name = "middle_name") 
    private String  middleName;
    
    @Column(name = "last_name") 
    private String  lastName;
     
    
    @Column(name = "bvn") 
    private String  bvn;
    
    
    @Column(name = "email") 
    private String  email;
    
    
    @Column(name = "phone_number") 
    private String  phoneNumber;
    
    
    @Column(name = "date_of_birth") 
    private String  dateOfBirth;
    
    
    @Column(name = "address") 
    private String  address;
    
    @Column(name = "location") 
    private String  location;
    
    
    @Column(name = "state")  
    private String  state;
    
     
    @Column(name = "country") 
    private String  country;
    
    
    @Size(min = 3, max = 6)
    @Column(name = "product_code") 
    private String  productCode;
    
    
    
    
    
}

