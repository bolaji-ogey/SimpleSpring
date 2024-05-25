/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource; 
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
 
//@Configuration  
class DataSourceConfig {

    /***
 @Value("${spring.datasource.username}")
private String user;

@Value("${spring.datasource.password}")
private String password;

@Value("${spring.datasource.url}")
private String dataSourceUrl;

@Value("${spring.datasource.driver-class-name}")
private String driverClassName;

@Value("${spring.datasource.jdbcUrl}")
private String jdbcUrl;

@Value("${spring.datasource.poolName}")
private String poolName;

@Value("${spring.datasource.connectionTimeout}")
private int connectionTimeout;

@Value("${spring.datasource.maxLifetime}")
private int maxLifetime;

@Value("${spring.datasource.maximumPoolSize}")
private int maximumPoolSize;

@Value("${spring.datasource.minimumIdle}")
private int minimumIdle;

@Value("${spring.datasource.idleTimeout}")
private int idleTimeout;


@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory()
{
    LocalContainerEntityManagerFactoryBean em
    = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(primaryDataSource());
    em.setPackagesToScan(new String[] { "i.ogeyingbo.simplespring.entities" });
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
  //  em.setJpaProperties(additionalProperties());
    return em;
}


@Bean(name = "secondaryDataSource")
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("mysqluser");
        dataSource.setPassword("mysqlpass");
        dataSource.setUrl("jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true");
    return dataSource;
}
 


@Primary
@Bean(name = "primaryDataSource")
public DataSource primaryDataSource() { 
    Properties dsProps = new Properties();
    dsProps.put("url", dataSourceUrl);
    dsProps.put("user", user);
    dsProps.put("password", password);
    dsProps.put("prepStmtCacheSize",250);
    dsProps.put("prepStmtCacheSqlLimit",2048);
    dsProps.put("cachePrepStmts",Boolean.TRUE);
    dsProps.put("useServerPrepStmts",Boolean.TRUE);

    Properties configProps = new Properties();
       configProps.put("driverClassName", driverClassName);
       configProps.put("jdbcUrl", jdbcUrl);
       configProps.put("poolName",poolName);
       configProps.put("maximumPoolSize",maximumPoolSize);
       configProps.put("minimumIdle",minimumIdle);
       configProps.put("minimumIdle",minimumIdle);
       configProps.put("connectionTimeout", connectionTimeout);
       configProps.put("idleTimeout", idleTimeout);
       configProps.put("dataSourceProperties", dsProps);

   HikariConfig hc = new HikariConfig(configProps);
   HikariDataSource ds = new HikariDataSource(hc);
   return ds;
   }

***/
  
    
    



} 
