package com.riwi.querertourapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para la administracion de usuarios en el proyecto QuerertouR",
        version= "1.0", description = "Api creada para gestionar del CRUD de usuarios con Swagger"))
public class OpenApiConfig {
}
