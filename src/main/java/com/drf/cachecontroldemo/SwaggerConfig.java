package com.drf.cachecontroldemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "basicAuth";

    @Bean
    public Docket entitlementApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .securitySchemes(newArrayList(basicAuth()))
                .securityContexts(newArrayList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.drf.cachecontroldemo.controller"))
                .build();
    }

    private BasicAuth basicAuth() {
        return new BasicAuth(SECURITY_SCHEME_NAME);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        return newArrayList(
                new SecurityReference(SECURITY_SCHEME_NAME, new AuthorizationScope[] { authorizationScope } ));
    }
}
