/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

@JsonPropertyOrder({"eventId", "eventType", "eventReference", "eventName",
                                   "eventDescription", "startDate", "endDate" })
@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name="facility")
public class Facility {
    
}
