package com.capgemini.fds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

// http://localhost:9090/OnlineFoodDeliveryApp/swagger-ui/
public class Main {

	public static void main(String[] args) {		
		
		SpringApplication.run(Main.class,args);
	}
}