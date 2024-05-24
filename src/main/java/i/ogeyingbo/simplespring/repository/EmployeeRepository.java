/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.repository;

import i.ogeyingbo.simplespring.dao.EmployeeRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import i.ogeyingbo.simplespring.model.Employee; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Repository
class   EmployeeRepository {
 
     @Autowired
    private JdbcClient jdbc;

    public List<Employee> getAllEmployees(){
            return jdbc.sql("select * from  employees")
              .query(new EmployeeRowMapper())
              .list();
    }
        
        
}
