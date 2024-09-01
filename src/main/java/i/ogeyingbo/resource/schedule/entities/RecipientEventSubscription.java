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

@JsonPropertyOrder({"recipientEventSubscriptionId", "eventCalendarId",  
               "recipientReference",   "eventReference", "eventSubscriptionId" })
@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name = "recipient_event_subscriptions")
public class RecipientEventSubscription {
    
    @JsonProperty("recipientEventSubscriptionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @JsonProperty("eventCalendarId")
    @Column(name = "event_calendar_id", nullable = false, unique = true)
    private   long  eventCalendarId;

    @JsonProperty("recipientReference")
    @Column(name = "recipient_reference", nullable = false)
    private String  recipientReference; // Matric Number, Staff ID, Trainer ID
    
    @JsonProperty("eventReference")
    @Column(name = "event_reference", nullable = false)
    private String  eventReference;  
    
    @JsonProperty("eventSubscriptionId")
    @Column(name = "event_subscription_id", nullable = false)
    private String  eventSubscriptionId; // Oourse Code
    
    
    
    
}
