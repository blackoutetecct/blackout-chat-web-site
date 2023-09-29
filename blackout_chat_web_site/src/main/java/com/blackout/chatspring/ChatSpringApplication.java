package com.blackout.chatspring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Blackout - Chat",
				version = "1.0.0",
				description = "",
				// termsOfService = "",

				contact = @Contact(
						name = "Kaique Souza Santos",
						email = ""
				),

				license = @License(
						name = "license",
						url = ""
				)
		)
)

@SpringBootApplication
public class ChatSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatSpringApplication.class, args);
	}
}
