/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"token", "expiresIn"})
@Getter @Setter @NoArgsConstructor 
public class LoginResponse {
    
    @JsonProperty("token")
    private String token;

    @JsonProperty("expiresIn")
    private long expiresIn;

    
}
