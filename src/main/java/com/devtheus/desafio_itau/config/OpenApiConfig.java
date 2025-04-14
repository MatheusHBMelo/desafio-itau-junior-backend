package com.devtheus.desafio_itau.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de transações")
                        .version("1.0.0")
                        .description("Documentação da API de transações com SpringDoc e OpenAPI 3")
                        .contact(new Contact()
                                .name("Matheus Barbosa")
                                .email("matheushbmelo@gmail.com")
                                .url("teste kkkk"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
