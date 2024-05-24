/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.controller.advice;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BookIdMismatchException extends RuntimeException {
    
    public BookIdMismatchException() {
       // super(message, cause);
    }

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}