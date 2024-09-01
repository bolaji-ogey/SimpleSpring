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

@JsonPropertyOrder({"resourceId", "resourceReference",  "resourceEventReferences" })
@Getter @Setter @NoArgsConstructor  
@Entity
@Table(name = "resource")
public class Resource {
    
    @JsonProperty("resourceId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @JsonProperty("resourceReference")
    @Column(name = "resource_reference", nullable = false, unique = true)
    private   String  resourceReference;  // Staff ID

    @Column(name = "resourceEventReferences", nullable = false)
    private String  resourceEventReferences; // Course codes seperated by comma.
}
