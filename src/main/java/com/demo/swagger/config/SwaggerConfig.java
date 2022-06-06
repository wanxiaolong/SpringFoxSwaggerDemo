package com.demo.swagger.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger使用的配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描带有@Api的类
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //扫描带有@ApiOperation的方法
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //扫描整个包
                .apis(RequestHandlerSelectors.basePackage("com.demo.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //基本的信息配置，会在API文档上显示
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger和SpringBoot整合")
                .description("Swagger的API文档")
                //维护者的联系方式
                .contact(new Contact("Maintainer", "http://localhost:8080/help", "someone@google.com"))
                .termsOfServiceUrl("http://localhost:8080/terms")
                .licenseUrl("http://localhost:8080/license")
                .version("v1.0")
                .build();
    }
}