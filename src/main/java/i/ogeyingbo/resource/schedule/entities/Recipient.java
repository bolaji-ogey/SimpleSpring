/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Recipient {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @Column(name = "recipient_reference", nullable = false, unique = true)
    private   String  recipientReference;  // Matric_no

    @Column(name = "recipient_event_references", nullable = false)
    private String  recipientEventReferences; // Course codes seperated by comma.
    
}
