package com.comex.springboot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * © Copyright Corp 2018<br>
 *
 *
 * The <code>com.comex.springboot.configs.SwaggerConfig</code> is about Swagger
 * configuration and enabling this configuration into this application.
 *
 *
 * @author mfmerola@gmail.com
 * @version 1.0
 * @since JDK1.8
 *
 *
 * @see org.springframework.context.annotation.Bean;
 * @see org.springframework.context.annotation.Configuration;
 * @see springfox.documentation.builders.RequestHandlerSelectors;
 * @see springfox.documentation.service.ApiInfo;
 * @see springfox.documentation.service.Contact;
 * @see springfox.documentation.spi.DocumentationType;
 * @see springfox.documentation.spring.web.plugins.Docket;
 * @see springfox.documentation.swagger2.annotations.EnableSwagger2;
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Mapping all APIs and enabling it into this application.
     * @return Docket
     */
    @Bean public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.comex.springboot"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    /**
     * Metadata regarding all APIs.
     * @return ApiInfo
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Demo REST API",
                "Demo REST API for Demo Corporation",
                "0.0.1",
                "Terms of service",
                new Contact("Mauro Merola"
                        , "https://www.linkedin.com/in/mauromerola/"
                        , "mfmerola@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}