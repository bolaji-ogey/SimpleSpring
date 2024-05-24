/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */



@Getter @Setter @NoArgsConstructor 
//@Data
@Entity
public class Book {
 
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;
    
    
     /***
      
    public  void  setId(long inId){
        id = inId;
    }
    
    
   
    public  void  setTitle(String  inTitle){
        title = inTitle;
    }
    
    
    public  void  setAuthor(String  inAuthor){
        author =  inAuthor;
    }
    
    
    public  long  getId(){
        return  this.id;
    }
    
    public  String  getTitle(){
        return  this.title;
    }
    
    
    public  String  getAuthor(){
        return this.author;
    }
    ***/
    
    
}
