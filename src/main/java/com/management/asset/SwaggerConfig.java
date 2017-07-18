package com.management.asset;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig configures the swagger 2 for Shop Controller
 * 
 * @author Vikram
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/**
	 * A Docket bean
	 * 
	 * @return Docket
	 */
	@Bean
    public Docket assetManagementApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages (false)
                .apiInfo(this.awesomeApiInfo())
                .select()            
                .paths(regex("/shops.*"))
                .apis(RequestHandlerSelectors.basePackage("com.management.asset.controller"))
                .build();
    }
	
	/**
	 * sets the default values
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo awesomeApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Asset Management API")
	                .description("")
	                .version("0.1")
	                .build();
	 }
}
