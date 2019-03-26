package com.alu.scaffold.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${spring.application.name}")
	public String applicationName;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.alu.scaffold.controller"))
				.paths(postPaths()).build()
				.apiInfo(apiInfo());
	}

	private Predicate<String> postPaths() {
		return or(regex("/posts.*"), regex("/*.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("China Alu API")
				.description("Alu API reference for developers")
				.termsOfServiceUrl("http://github.com")
				.contact(new Contact("chenjialu", "http://github.com", "chenjialu0804@163.com"))
				.license("Alu License")
				.version("1.0")
				.build();
	}

}