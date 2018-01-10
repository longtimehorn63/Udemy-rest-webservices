package com.udemy.rest.webservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/*
 * use
 * http://localhost:8080/v2/api-docs or
 * http://localhost:8080/swagger-ui.html
 */
public class SwaggerConfig {

	  public static final Contact DEFAULT_CONTACT = new Contact(
			  "Me", "http://www.google.com", "www.someaddress.com");
	  public static final ApiInfo DEFAULT = new ApiInfo(
			  "Awesome Api title", 
			  "Awesome Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", 
	          "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<>(Arrays.asList("application/json","application/xml"));
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}
