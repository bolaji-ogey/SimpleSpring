/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.controller.advice;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class EmployeeNotFoundException extends RuntimeException {

    
    public EmployeeNotFoundException(String message) {
               super(message); 
    }
    
    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}
