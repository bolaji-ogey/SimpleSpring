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
@Table(name = "recipient_event_subscriptions")
public class RecipientEventSubscription {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @Column(name = "event_calendar_id", nullable = false, unique = true)
    private   long  eventCalendarId;

    @Column(name = "recipient_reference", nullable = false)
    private String  recipient_reference; // Matric Number, Staff ID, Trainer ID
    
    
    @Column(name = "event_reference", nullable = false)
    private String  eventReference;  
    
    
    @Column(name = "event_subscription_id", nullable = false)
    private String  eventSubscriptionId; // Oourse Code
    
    
    
    
}
