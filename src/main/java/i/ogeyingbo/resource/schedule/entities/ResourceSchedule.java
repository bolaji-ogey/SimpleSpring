/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.entities;

import i.ogeyingbo.resource.schedule.enums.EventType;
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
@Table(name = "resource_schedules")
public class ResourceSchedule {
    
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;
    
    @Column(name = "event_id", nullable = false)
    private long eventId;
      
    @Column(name = "event_subscription_id", nullable = false)
    private String  eventSubscriptionId; 
    
    @Column(name = "event_reference", nullable = false)
    private String  eventReference; 
    
    @Column(name = "event_type", nullable = false)
    private EventType  eventType; 
      
    @Column(name = "facility_reference", nullable = false)
    private String  facilityReference; // default is time or day
     
    @Column(name = "event_day", nullable = false)
    private int  eventDay; // default is time or day
    
   @Column(name = "event_month", nullable = false)
    private String  eventMonth; // default is time or day
     
    @Column(name = "event_year", nullable = false)
    private int  eventYear; // default is time or day
    
    @Column(name = "event_start_time", nullable = false)
    private int  eventStartTime;  
    
    
    @Column(name = "event_end_time", nullable = false)
    private int  eventEndTime;  
    
     
     
    @Column(name = "resource_event_subscription_id", nullable = false)
    private String  resourceEventSubscriptionId; // Staff_ID
    
    @Column(name = "resource_event_reference", nullable = false)
    private String  resourceEventReference; // Oourse Code
    
}
