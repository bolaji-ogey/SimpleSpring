/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */


@JsonPropertyOrder({"id","title","genre","isbn","author","year_published"})
@Getter @Setter @NoArgsConstructor 
@Data
@Entity
@Table(name = "book_inventory")
public class Book {
 
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   long id;

    @JsonProperty("title")
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    
    @JsonProperty("genre")
    @Column(name = "genre", nullable = false)
    private String genre;
    
    @JsonProperty("isbn")
    @Column(name = "isbn", nullable = false)
    private String isbn;
    
    
    @JsonProperty("author")
    @Column(name = "author", nullable = false)
    private String author;
    
    @JsonProperty("year_published")
    @Column(name = "year_published", nullable = false)
    private String  yearPublished;
    
    
  
}
