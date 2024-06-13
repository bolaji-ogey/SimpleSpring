/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.resource.schedule.repository;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

import i.ogeyingbo.online.bookstore.model.objects.InventoryBook;
import  i.ogeyingbo.simplespring.dao.InventoryBookRowMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Repository
public class  ScheduleRepository {
    
    
     private final JdbcClient jdbcClient;

  public   ScheduleRepository(DataSource dataSource) {
    this.jdbcClient = JdbcClient.create(dataSource);
  }

    public List<InventoryBook> getBookInventory(){
        
             StringBuilder    selectQuery  =  new  StringBuilder(200);
                selectQuery.append(" SELECT  book_inventory.id as id,  book_inventory.title as title,   ");
                selectQuery.append(" book_inventory.genre as genre,  book_inventory.isbn as isbn,  ");
                selectQuery.append(" book_inventory.author as author,  book_inventory.year_published as year_published,  ");
                selectQuery.append("  book_prices.price as price,  book_prices.units_in_stock as  units_in_stock "); 
                selectQuery.append("  FROM  book_inventory  JOIN  book_prices  ");
                selectQuery.append("  ON  (book_prices.book_id  =  book_inventory.id) ");
                
            return jdbcClient.sql(selectQuery.toString())
              .query(new InventoryBookRowMapper())
              .list();
    }
      
    
    
}
