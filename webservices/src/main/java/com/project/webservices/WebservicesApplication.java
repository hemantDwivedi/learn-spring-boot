package com.project.webservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "User management API documentation",
				description = "Spring boot REST API documentation",
				version = "1.0",
				contact = @Contact(
						name = "Hemant",
						email = "hemant@gmail.com",
						url = "www.google.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "www.google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "spring boot user management documentation",
				url = "www.google.com"
		)
)
public class WebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
