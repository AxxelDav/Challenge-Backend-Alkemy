package com.proyecto.proyecto.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguracion {

  @Bean
  public Docket apiDocket() {
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build()
              .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
      return new ApiInfo(
              "Backend Challenge - Alkemy",
              "Este es un proyecto challenge para Alkemy",
              "1.0",
              "Website",
              new Contact("Axel", "website", "axeld.cespedes@gmail.com"),
              "LICENSE",
              "LICENSE URL",
              Collections.emptyList()
              );
  }

}


