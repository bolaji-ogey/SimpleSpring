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

@JsonPropertyOrder({"resourceEventSubscriptionId", "eventCalendarId",  
               "resourceReference",   "eventReference", "eventSubscriptionId" })
@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name = "resource_event_subscription")
public class ResourceEventSubscription {
    
    @JsonProperty("resourceEventSubscriptionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @JsonProperty("eventCalendarId")
    @Column(name = "event_calendar_id", nullable = false, unique = true)
    private   long  eventCalendarId;

    @JsonProperty("resourceReference")
    @Column(name = "resource_reference", nullable = false)
    private String  resourceReference; // Matric Number, Staff ID, Trainer ID
    
    @JsonProperty("eventReference")
    @Column(name = "event_reference", nullable = false)
    private String  eventReference;  
    
    @JsonProperty("eventSubscriptionId")
    @Column(name = "event_subscription_id", nullable = false)
    private String  eventSubscriptionId; // Oourse Code
    
}
