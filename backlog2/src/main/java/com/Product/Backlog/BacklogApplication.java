package com.Product.Backlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication   //provides Auto-configuration
public class BacklogApplication {  //Spring boot application

	public static void main(String[] args) {  //entry point of application 
		SpringApplication.run(BacklogApplication.class, args); //accepts HTTP incoming requests
	}

	@Bean  //configures cross origin resource sharing 
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
			}
		};
	}

}
