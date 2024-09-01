/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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

@JsonPropertyOrder({"recipientId", "recipientReference", "recipientEventReferences" })
@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name = "recipient")
public class Recipient {
    
    @JsonProperty("recipientId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @JsonProperty("recipientReference")
    @Column(name = "recipient_reference", nullable = false, unique = true)
    private   String  recipientReference;  // Matric_no

    @JsonProperty("recipientEventReferences")
    @Column(name = "recipient_event_references", nullable = false)
    private String  recipientEventReferences; // Course codes seperated by comma.
    
}
