/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package i.ogeyingbo.simplespring;


import  org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@EnableJpaRepositories("i.ogeyingbo.simplespring.repository") 
@EntityScan("i.ogeyingbo.simplespring.model")
@SpringBootApplication
public class SpringApp {
    
    static{
        AnsiConsole.systemInstall();
    }
    
    public static void main(String[] args) { 
        SpringApplication.run(SpringApp.class, args);
    }
    
    
}
