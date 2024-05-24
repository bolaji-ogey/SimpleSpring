/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.dao;

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
    String appConfigPath = "";
    private static HikariConfig config = null;   //new HikariConfig();
 //   private static HikariConfig config = new HikariConfig("../properties_file_path");
    private static HikariDataSource ds;
    private static  String jdbcUrl = "jdbc:postgresql://localhost:5432/new_portal?useSSL=false&serverTimezone=UTC";    
    private static  String username = "postgres";
    private static  String password = "admin";
    
    

    static {
        rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
         System.out.println("PGDataSource root path =>   "+rootPath);
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
   
    
    
    private PGDataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    
    public   Connection getConnect() throws SQLException {
        return ds.getConnection();
    }
    
    
}
