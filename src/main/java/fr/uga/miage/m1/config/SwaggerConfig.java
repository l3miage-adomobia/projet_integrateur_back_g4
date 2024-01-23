package fr.uga.miage.m1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Cette classe correspond à une configuration pour le swagger de l'application<br>
 * Les Annotations :
 * <ul>
 *     <li>{@link Configuration} permet de créer une configuration spring, cette annotation est en quelque sorte un stéréotype d'un @{@link Bean}, car elle va permettre de créer un candidat à l'injection.</li>
 * </ul>
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}