/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name = "resource")
public class Resource {
    
   @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @Column(name = "resource_reference", nullable = false, unique = true)
    private   String  resourceReference;  // Staff ID

    @Column(name = "resource_event_references", nullable = false)
    private String  resourceEventReferences; // Course codes seperated by comma.
}
