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
@Table(name = "event_calendar")
public class EventCalendar {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;
    
    @Column(name = "event_type", nullable = false)
    private EventType  eventType;   // Examination, Lecture

    @Column(name = "event_reference", nullable = false, unique = true)
    private String  eventReference;   

    @Column(name = "event_name", nullable = false)
    private String  eventName; 
    
    @Column(name = "event_description", nullable = false)
    private String  eventDescription;
    
    @Column(name = "end_date", nullable = false)
    private String  startDate;
    
    
    @Column(name = "start_date", nullable = false)
    private String  endDate;
    
    
    
}
