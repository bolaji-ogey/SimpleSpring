/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.repository;

import i.ogeyingbo.simplespring.dao.EmployeeRowMapper;
import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import i.ogeyingbo.simplespring.model.Employee; 
import javax.sql.DataSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
//@Component
@Repository
class   EmployeeRepository {
 
 private final JdbcClient jdbcClient;

  public EmployeeRepository(DataSource dataSource) {
    this.jdbcClient = JdbcClient.create(dataSource);
  }

    public List<Employee> getAllEmployees(){
            return jdbcClient.sql("select * from  employees")
              .query(new EmployeeRowMapper())
              .list();
    }
      
    
   /**   
    List<Student> getStudentsOfGradeStateAndGenderWithPositionalParams(int grade, String state, String gender) {
      String sql = "select student_id, student_name, age, grade, gender, state from student"
              + " where grade = ? and state = ? and gender = ?";
      return jdbcClient.sql(sql)
        .param(grade)
        .param(state)
        .param(gender)
        .query(new StudentRowMapper()).list();
  }
  ***/      
    
    
}
