/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.entities;

import i.ogeyingbo.resource.schedule.enums.EventType;
import i.ogeyingbo.resource.schedule.enums.FacilityType;
import i.ogeyingbo.resource.schedule.enums.ResourceType;
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
@Table(name = "master_schedules")
public class  MasterSchedule {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @Column(name = "context", nullable = false, unique = true)
    private String  context;  // Name of institution

    @Column(name = "scope", nullable = false)
    private String  scope; // Start and End Date of program
    
    @Column(name = "event_type", nullable = false)
    private EventType  eventType;   // Examination, Lecture
    
    @Column(name = "event_id", nullable = false)
    private long eventId;
    
    @Column(name = "event_reference", nullable = false)
    private String  eventReference; // Examination_Time-Table,  Lecture_Time-Table,  
     
    
    @Column(name = "facility", nullable = false)
    private FacilityType  facilityType; // ClassRoom, Room, Theater -- Facility
    
    @Column(name = "facility_reference", nullable = false)
    private String  facilityReference; // default is time or day
    
    @Column(name = "resource_type", nullable = false)
    private  ResourceType  resourceType; // Lecturer, Vehicle, -- Someone providing or Something  that can be used to provide service
    
    
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
    
    
    
    @Column(name = "resource_reference", nullable = false)
    private String  resourceReference; // default is time or day
     
    
}
