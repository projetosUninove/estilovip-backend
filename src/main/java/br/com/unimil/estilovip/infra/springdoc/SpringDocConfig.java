package br.com.unimil.estilovip.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description("Documentação Externa da API no GitHub")
                .url("https://github.com/projetosUninove/estilovip-backend");

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("estilovip API")
                        .description("Estilo vipe é uma api de controle de estoque e vendas online voltada para e-commerce")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("por email")
                                .email("amrennan@gmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://www.mit.edu/~amini/LICENSE.md")))
                .externalDocs(externalDocumentation);
    }

}