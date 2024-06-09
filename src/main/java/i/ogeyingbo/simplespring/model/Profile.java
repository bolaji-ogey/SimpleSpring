/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hc.client5.http.utils.Base64;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class Profile {

     @Builder.Default  private  long  id = -1;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private String fullName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private String designation;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private String githubLink;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private String twitterLink;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private String email;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
    private byte[] imageData;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.imageData);
    }
    
    
    
}
