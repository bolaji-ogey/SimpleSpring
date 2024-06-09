/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.dao;

import i.ogeyingbo.online.bookstore.model.objects.InventoryBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class InventoryBookRowMapper implements RowMapper<InventoryBook> {
    
    @Override
    public InventoryBook mapRow(ResultSet rs, int rowNum) throws
    SQLException {
        
            InventoryBook   inventoryBook  =  new  InventoryBook();

             inventoryBook.setId( rs.getInt("id")); 
             inventoryBook.setTitle(rs.getString("title").trim());
             inventoryBook.setGenre(rs.getString("genre").trim());
             inventoryBook.setIsbn(rs.getString("isbn").trim());
             inventoryBook.setAuthor(rs.getString("author").trim());
             inventoryBook.setYearPublished(rs.getString("year_published").trim()); 
             inventoryBook.setPrice(rs.getBigDecimal("price"));
             inventoryBook.setUnitsInStock( rs.getInt("units_in_stock")); 
             
    return inventoryBook;
    }
    
    
}
