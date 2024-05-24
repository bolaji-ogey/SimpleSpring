/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.repository;

import i.ogeyingbo.simplespring.entities.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    
    List<Book> findByTitle(String title);
    
}