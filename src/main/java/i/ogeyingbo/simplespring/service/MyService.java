/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.service;

import i.ogeyingbo.simplespring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;

import org.springframework.web.reactive.function.client.WebClient;
import  reactor.core.publisher.Mono;

import   i.ogeyingbo.simplespring.controller.advice.EmployeeNotFoundException;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@Service
public class MyService {

  private final WebClient webClient;

  @Autowired
  public MyService(WebClient webClient) {
      this.webClient = webClient;
  }

  public Mono<Employee> createEmployee(Employee employee) {

    Mono<Employee> employeeMono = webClient.post()
      .uri("/employees")
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .body(Mono.just(employee), Employee.class)
      .retrieve()
      .bodyToMono(Employee.class);

    return employeeMono;
  }
  
  
   public Mono<Employee> getEmployeeByID(int inEmployeeID) {

    Mono<Employee> employeeMono = webClient.get()
    .uri("/employees/{id}", inEmployeeID)
    .retrieve()
    .bodyToMono(Employee.class);

    return employeeMono;
  }
    
  
   
   public   void  deleteEmployeeByID(int inEmplID){
       webClient.delete()
            .uri("/employees/" + inEmplID)
            .retrieve()
            .bodyToMono(Void.class);
   }
  
   
   
   
   
     public Mono<Employee> fetchEmployeeById(int id) {
    return webClient.get()
      .uri("/employees/{id}", id)
      .exchangeToMono(this::handleResponse);
  }

     
     
  private Mono<Employee> handleResponse(ClientResponse response) {

    if (response.statusCode().is2xxSuccessful()) {
      return response.bodyToMono(Employee.class);
    } 
    else if (response.statusCode().is4xxClientError()) {
      // Handle client errors (e.g., 404 Not Found)
      return Mono.error(new EmployeeNotFoundException("Employee not found"));
    } 
    else if (response.statusCode().is5xxServerError()) {
      // Handle server errors (e.g., 500 Internal Server Error)
      return Mono.error(new RuntimeException("Server error"));
    } 
    else {
      // Handle other status codes as needed
      return Mono.error(new RuntimeException("Unexpected error"));
    }
  }
  
  
  
  
}