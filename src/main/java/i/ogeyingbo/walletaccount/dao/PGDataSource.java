/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.walletaccount.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PGDataSource {
     
    private static String rootPath = "";
    private  String  databaseName  = "";
    String appConfigPath = "";
    private static HikariConfig config = null;   //new HikariConfig();
 //   private static HikariConfig config = new HikariConfig("../properties_file_path");
    private static HikariDataSource ds;
    private  static String jdbcUrl = "jdbc:postgresql://localhost:5432/bookinventory?useSSL=false&serverTimezone=UTC";
    private static  String username = "root";
    private static  String password = "admin";
    
    
   /****
    static {
        rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
         String appConfigPath = rootPath + "pg_data_source.properties";
         config = new HikariConfig(appConfigPath);
         System.out.println("appConfigPath:  "+appConfigPath);
    
       // config.setJdbcUrl( jdbcUrl); 
       // config.addDataSourceProperty( "cachePrepStmts" , "true" );
       // config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
       // config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
       // config.addDataSourceProperty( "idleTimeout " , "30000" );
       // config.addDataSourceProperty( "maxLifeTime" , "30000" );
        ds = new HikariDataSource( config );
          
    }
   ***/
     
    
   private  static  PGDataSource   dataSourcex; 
   
   
    public static PGDataSource getInstance()
    {
        if (dataSourcex == null)
        {
            synchronized (PGDataSource.class)
            { 
                dataSourcex = new PGDataSource();
            } 
        }
        return   dataSourcex;
    }
    
    
        
    public static PGDataSource getInstance(String  inDatabaseName)
    {
        if (dataSourcex == null)
        {
            synchronized (PGDataSource.class)
            { 
                dataSourcex = new PGDataSource(inDatabaseName);
            } 
        }
        return   dataSourcex;
    }
   
    
    
    private PGDataSource() {
          rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
         String appConfigPath = rootPath + "pg_data_source.properties";
         config = new HikariConfig(appConfigPath);
         System.out.println("appConfigPath:  "+appConfigPath);
    
       // config.setJdbcUrl( jdbcUrl); 
       // config.addDataSourceProperty( "cachePrepStmts" , "true" );
       // config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
       // config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
       // config.addDataSourceProperty( "idleTimeout " , "30000" );
       // config.addDataSourceProperty( "maxLifeTime" , "30000" );
        ds = new HikariDataSource( config );
    }
    
    
    private PGDataSource(String  inDatabaseName) {
        
        jdbcUrl = "jdbc:postgresql://localhost:5432/"+inDatabaseName+"?username=postgres&password=admin";
        
         config =  new HikariConfig();
         config.setJdbcUrl( jdbcUrl); 
         config.setUsername("postgres" );
         config.setPassword("admin" );
         config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
         config.addDataSourceProperty( "cachePrepStmts" , "true" );
         config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
         config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
         config.addDataSourceProperty( "idleTimeout " , "30000" );
         config.addDataSourceProperty( "maxLifeTime" , "30000" );
        ds = new HikariDataSource( config );
    }
    

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    
    public   Connection getConnect() throws SQLException {
        return ds.getConnection();
    }
    
    
}
