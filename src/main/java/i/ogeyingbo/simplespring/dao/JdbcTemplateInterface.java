/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.dao;

import i.ogeyingbo.simplespring.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class JdbcTemplateInterface {
 
    
     @Autowired
     JdbcTemplate   jdbcTemplate;
     
     @Autowired
     NamedParameterJdbcTemplate   namedParameterJdbcTemplate;
     
     @Autowired
     DataSource  dataSource;
     
    
     
     /***
     
      public  Employee   getEmployeeById(int inId){  
          String query = "SELECT * FROM EMPLOYEE WHERE ID = ? ";
          Connection  cron  = dataSource.getConnection();
          return  jdbcTemplate.queryForObject(
              query,  new EmployeeRowMapper(), new Object[] { inId });
        }
       
    ***/  

     
     
       public  Employee   getEmployeeById(int inId){  
          String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
          return  jdbcTemplate.queryForObject(
              query,  new EmployeeRowMapper(), new Object[] { inId });
        }

       
       
       public  List<Employee>   getAllEmployees(){  
          String query = "SELECT * FROM EMPLOYEE ";
          return  jdbcTemplate.query(query,  new EmployeeRowMapper());
        }
       
       
       public int  getEmployeeCount_Safe() {
          int result   =  -1;
          try{
              result  = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
          }catch(Exception ex){
              ex.printStackTrace();
          }
          return  result;
       }
       
       
       
       public int  getEmployeeCount() {
          return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
       }
       
       
       
       
       public int addEmplyee(int id) {
            return jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)", 
                                         5, "Bill", "Gates", "USA");
        }
       
       

       /****/
      public int addEmplyee(Employee   emp) {
          
          SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).
                                                        withTableName("EMPLOYEE");

          Map<String, Object> parameters = new HashMap<String, Object>();
          parameters.put("ID", emp.getId());
          parameters.put("FIRST_NAME", emp.getFirstName());
          parameters.put("LAST_NAME", emp.getLastName());
          parameters.put("ADDRESS", emp.getAddress());          
          
          return  simpleJdbcInsert.execute( parameters);
      }

      
      
       
        public Employee getEmployeeUsingSimpleJdbcCall(int id) {
                SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                                                           .withProcedureName("READ_EMPLOYEE");
              SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
              Map<String, Object> out = simpleJdbcCall.execute(in);
              Employee emp = new Employee();
              emp.setFirstName((String) out.get("FIRST_NAME"));
              emp.setLastName((String) out.get("LAST_NAME"));
        return emp;
      }

        
     public  long    insertAndReturnPrimaryKey_Safe(Map<String, Object> parameters){
         SimpleJdbcInsert simpleJdbcInsert = null;
           Number id =  null;
           
           try{
               simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                                                                  .withTableName("EMPLOYEE")
                                                                  .usingGeneratedKeyColumns("ID");
                 id = simpleJdbcInsert.executeAndReturnKey(parameters);
                  System.out.println("Generated id - " + id.longValue());
           }catch(Exception ex){
               ex.printStackTrace();
           }
        return  id.longValue();
     }
         
         
         
        

     public  long    insertAndReturnPrimaryKey(Map<String, Object> parameters){
      SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                                                        .withTableName("EMPLOYEE")
                                                        .usingGeneratedKeyColumns("ID");
        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        System.out.println("Generated id - " + id.longValue());
        return  id.longValue();
     }

        
         public int[] batchUpdateUsingJdbcTemplate_Safe(List<Employee> employees) {
              int[]  updateCount = null;
              try{
                updateCount = jdbcTemplate.batchUpdate("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)", 
                                                            new BatchPreparedStatementSetter() {
                            @Override
                            public void setValues(PreparedStatement ps, int i) throws
                            SQLException {
                                ps.setInt(1, employees.get(i).getId());
                                ps.setString(2, employees.get(i).getFirstName());
                                ps.setString(3, employees.get(i).getLastName());
                                ps.setString(4, employees.get(i).getAddress());
                            }

                            @Override
                            public int getBatchSize() {
                            return 50;
                            }
                        });
              }catch(Exception ex){
                  ex.printStackTrace();
              }
            return  updateCount;
        }
         
        /****/ 
        
        
        public int[] batchUpdateUsingJdbcTemplate(List<Employee> employees) {
        return jdbcTemplate.batchUpdate("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)", 
                                                    new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws
                    SQLException {
                        ps.setInt(1, employees.get(i).getId());
                        ps.setString(2, employees.get(i).getFirstName());
                        ps.setString(3, employees.get(i).getLastName());
                        ps.setString(4, employees.get(i).getAddress());
                    }
                    
                    @Override
                    public int getBatchSize() {
                    return 50;
                    }
                });
        }
      
        
        
        
      public  int[]  executeBatchUpdate_Safe(List<Employee>   employees){
          
          SqlParameterSource[] batch =  null;
          int updateCounts[]  =  null;
            try{
                batch = SqlParameterSourceUtils.createBatch(employees.toArray());
                updateCounts = namedParameterJdbcTemplate.batchUpdate(
                "INSERT INTO EMPLOYEE VALUES (:id, :firstName, :lastName,  :address)", batch);
            }catch(Exception ex){
                ex.printStackTrace();
            }
          return   updateCounts;
      }
      
      
      

      public  int[]  executeBatchUpdate(List<Employee>   employees){
          SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(employees.toArray());
          int updateCounts[]  = namedParameterJdbcTemplate.batchUpdate(
          "INSERT INTO EMPLOYEE VALUES (:id, :firstName, :lastName,  :address)", batch);
          return   updateCounts;
      }





}
