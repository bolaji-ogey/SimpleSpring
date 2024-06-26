/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
//@Configuration
//@EnableTransactionManagement
public class PersistenceJPAConfig{
    
    
               // @Bean
                public LocalContainerEntityManagerFactoryBean entityManagerFactory()
                {
                    LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
                    em.setDataSource(dataSource());
                    em.setPackagesToScan(new String[] { "com.baeldung.persistence.model" });
                    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
                    em.setJpaVendorAdapter(vendorAdapter);
                   // em.setJpaProperties(additionalProperties());
                    return em;
                }



              //  @Bean
                public DataSource dataSource() {
                    DriverManagerDataSource dataSource = new DriverManagerDataSource();
                        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                        dataSource.setUsername("mysqluser");
                        dataSource.setPassword("mysqlpass");
                        dataSource.setUrl("jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true");
                    return dataSource;
                }



} 
