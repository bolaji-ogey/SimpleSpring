/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.service;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

import i.ogeyingbo.simplespring.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    
  private final WebClient webClient;

  public EmployeeService(WebClient webClient) {
    this.webClient = webClient;
  }

  
  /***
  public Flux<Employee> getAllEmployees() {

    return webClient.get()
      .uri("/employees")
      .retrieve()
      .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
              clientResponse -> handleErrorResponse((HttpStatus)clientResponse.statusCode()))
      .bodyToFlux(Employee.class)
      .onErrorResume(Exception.class, e -> Flux.empty()); // Return an empty collection on error
  }

  public Mono<Employee> getEmployeeById(int id) {
    return webClient.get()
            .uri("/employees/{id}", id)
            .retrieve()
            .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                    clientResponse -> handleErrorResponse((HttpStatus)clientResponse.statusCode()))
            .bodyToMono(Employee.class);
  }

  private Mono<? extends Throwable> handleErrorResponse(HttpStatus statusCode) {

    // Handle non-success status codes here (e.g., logging or custom error handling)
    return Mono.error(new EmployeeServiceException("Failed to fetch employee. Status code: " + statusCode));
  }
  
  
  
  
  
  
  
public Mono<ResponseEntity<Employee>> createEmployee(Employee newEmployee) {

    return webClient.post()
      .uri("/employees")
      .body(Mono.just(newEmployee), Employee.class)
      .retrieve()
      .onStatus(HttpStatus::is4xxClientError, response -> {
        //logError("Client error occurred");
        return Mono.error(new WebClientResponseException
          ("Bad Request", response.statusCode().value(), null, null, null));
      })
      .onStatus(HttpStatus::is5xxServerError, response -> {
        //logError("Server error occurred");
        return Mono.error(new WebClientResponseException
          ("Server Error", response.statusCode().value(), null, null, null));
      })
      .toEntity(Employee.class);
   
}





  
  
public  Mono<Employee>   updateEmployee(Employee updatedEmployee) {

  return webClient.put()
    .uri("/employees/{id}", updatedEmployee.getId())
    .body(Mono.just(updatedEmployee), Employee.class)
    .retrieve()
    .onStatus(HttpStatus::is4xxClientError, clientResponse -> handleClientError(clientResponse))
    .onStatus(HttpStatus::is5xxServerError, clientResponse -> handleServerError(clientResponse))
    .bodyToMono(Employee.class);
}


private Mono<? extends Throwable> handleClientError(ClientResponse clientResponse) {
  // Handle client errors (e.g., 404 Not Found) here
  return Mono.error(new EmployeeNotFoundException("Employee not found"));
}

private Mono<? extends Throwable> handleServerError(ClientResponse clientResponse) {
  // Handle server errors (e.g., 500 Internal Server Error) here
  return Mono.error(new RuntimeException("Server error"));
}





public  Mono<Void>   deleteEmployee(Integer id) {
  return webClient.delete()
    .uri("/employees/" + id)
    .retrieve()
    .onStatus(HttpStatus::is4xxClientError, clientResponse -> handleClientError(clientResponse))
    .onStatus(HttpStatus::is5xxServerError, clientResponse -> handleServerError(clientResponse))
    .bodyToMono(Void.class);
}


private Mono<? extends Throwable> handleClientError(ClientResponse clientResponse) {
    // Handle client errors (e.g., 404 Not Found) here
    return Mono.error(new EmployeeNotFoundException("Employee not found"));
}

private Mono<? extends Throwable> handleServerError(ClientResponse clientResponse) {
    // Handle server errors (e.g., 500 Internal Server Error) here
    return Mono.error(new RuntimeException("Server error"));
}

***/


  
}

