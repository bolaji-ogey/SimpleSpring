/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.config;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebConfig {

  @Bean
  @Primary
  public WebClient webClient() {

   return   WebClient.builder()
      .baseUrl("http://localhost:3000")
      .defaultCookie("cookie-name", "cookie-value")
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build();
     
  }
  
  
  
  
    @Bean
    public WebClient getWebClient() {

      HttpClient httpClient = HttpClient.create()
        .tcpConfiguration(client ->
            client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
            .doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler(10))
                .addHandlerLast(new WriteTimeoutHandler(10))));

      ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);     

      return WebClient.builder()
        .baseUrl("http://localhost:3000")
        .clientConnector(connector)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
    }



}