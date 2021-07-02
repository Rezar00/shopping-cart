package com.atlavik.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@ConditionalOnExpression(value = "${app.useSwagger:false}")
@EnableSwagger2
public class SwaggerConfig {

    @Value("${app.version}")
    private String appVersion;

    @Bean
    public Docket apiAuth() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atlavik.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .groupName("SHOPPING CART API");
    }

    private ApiInfo metaData() {
        return new ApiInfo("Shopping Cart REST API", "This application is Shopping",
                appVersion, "",
                new Contact("Reza Roshani", "reza.roshani00@gmail.com", "reza.roshani00@gmail.com"),
                "", "", new ArrayList<>());
    }
}
