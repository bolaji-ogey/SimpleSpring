/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hc.client5.http.utils.Base64;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image_objects")
public class ImageObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Lob
    @Column
    private byte[] imageData;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.imageData);
    }
}
