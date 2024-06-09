/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.online.bookstore.model.objects;


 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PastOrPresent;


/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Book {
    
    
    
    @NotBlank(message = "Title cannot be null or empty") @Pattern(regexp="[a-zA-Z0-9]")
    private String title;  // must contain only numbers and letters) 
    
    @NotBlank(message = "Genre cannot be null or empty")
    private String genre;  // it should be limited to Friction, Thriller, Mystery, Poetry, Horror, and Satire 
    
    @NotBlank(message = "ISBN  cannot be null or empty")  @Pattern(regexp="[0-9-]")
    private String isbn; // must contain only numbers and dash(-)
    
    @NotBlank(message = "Author's name cannot be null or empty") @Pattern(regexp="[a-zA-Z ]")
    private String author;
    
    @PastOrPresent(message = "Name cannot be null ")
    private String yearPublished;
    
    
    public  void  setTitle(String  inTitle){
        title = inTitle;
    }
    
    public  void  setGenre(String  inGenre){
        genre = inGenre;
    }
    
    public  void  setIsbn(String  inIsbnCode){
        isbn  = inIsbnCode;
    }
    
    public  void  setAuthor(String  inAuthor){
        author = inAuthor;
    }
    
    public  void  setYearPublished(String  inYearPublished){
        yearPublished = inYearPublished;
    }
    
    
    
    
    
    
    
    public  String  getTitle(){
       return   title;
    }
    
    public  String  getGenre(){
        return   genre;
    }
    
    public  String  getIsbn(){
        return   isbn;
    }
    
    public  String  getAuthor(){
        return   author;
    }
    
    public  String  getYearPublished(){
        return   yearPublished;
    }
    
    
    
    
     
}
