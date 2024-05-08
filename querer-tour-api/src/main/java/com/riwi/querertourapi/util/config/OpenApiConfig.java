package com.riwi.querertourapi.util.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Api to administrate endpoints of QuerertouR",
                version = "1.0",
                description = "This api was created for QuerertouR"
        )
)
public class OpenApiConfig {
}
