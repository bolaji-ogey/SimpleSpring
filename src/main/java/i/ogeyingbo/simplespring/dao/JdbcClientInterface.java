/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.dao;

import i.ogeyingbo.simplespring.model.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
//@Component
public class JdbcClientInterface {
  
    /***
    @Autowired
    JdbcTemplate   jdbcTemplate;
    
  public  List   getEmployeeById(){  
    String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
    List<Employee> employees = jdbcTemplate.queryForObject(
        query,  new EmployeeRowMapper(), new Object[] { id });
  }
  
 
public int addEmplyee(Employee emp) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("ID", emp.getId());
    parameters.put("FIRST_NAME", emp.getFirstName());
    parameters.put("LAST_NAME", emp.getLastName());
    parameters.put("ADDRESS", emp.getAddress());
return  jdbcTemplate.execute(parameters);
}
  
  
  List<Student> getStudentsOfGradeStateAndGenderWithPositionalParams(int grade, String state, String gender) {
    String sql = "select student_id, student_name, age, grade, gender, state from student"
            + " where grade = ? and state = ? and gender = ?";
    return jdbcClient.sql(sql)
      .param(grade)
      .param(state)
      .param(gender)
      .query(new StudentRowMapper()).list();
}
  
  ****/ 

    
    
    
    
    
}


