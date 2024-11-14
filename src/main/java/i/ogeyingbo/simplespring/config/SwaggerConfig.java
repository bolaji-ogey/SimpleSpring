/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
 @Configuration
public class SwaggerConfig {
String schemeName = "bearerAuth";
String bearerFormat = "JWT";
String scheme = "bearer";


 @Bean
public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                  .addSecurityItem(new SecurityRequirement()
.addList(schemeName)).components(new Components()
                                  .addSecuritySchemes(
                                        schemeName, new SecurityScheme()
                                        .name(schemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .bearerFormat(bearerFormat)
                                        .in(SecurityScheme.In.HEADER)
                                        .scheme(scheme)
                                  )
                  )
                  .info(new Info()
                              .title("Pouchii School API Service")
                              .description("School API Functions Information")
                              .version("1.0")
                  );
        }
}