package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe per poder fer servir swagger
 * Indiquem el paquet base des del qual escanejar l'aplicació
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02"))
                .paths(PathSelectors.any())
                .build();
    }
}
