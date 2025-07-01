package com.Cidenet.registro.commons.configurations;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RegistroApp Application")
                        .version("0.1")
                        .description("API to manage data for RegistroApp Application")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Official Docs")
                        .url("https://www.google.com.co/"));

    }

    @Bean
    public GroupedOpenApi registroEmpleadoApi() {
        return GroupedOpenApi.builder().group("registroEmpleado")
                .packagesToScan("com.Cidenet.registro.infrastructure.endpoints.rest") // Escanea el paquete de RegistroEmpleadoController
                .build();
    }
}
