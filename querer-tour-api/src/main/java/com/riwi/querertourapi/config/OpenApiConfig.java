package com.riwi.querertourapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


/**
 * Aquí configuramos la librería de
 * swagger
 * */
@Configuration // Para configurar beans dentro de spring
@OpenAPIDefinition(
        info = @Info(
                title = "Api para administración de los pueblos.",
                version = "1.0",
                description = "Esta API fue creada para el proyecto QuerertouR, donde se está aprendiendo acerca de los fundamentos de Spring Boot y Spring JPA."
        )
)

public class OpenApiConfig {

}
