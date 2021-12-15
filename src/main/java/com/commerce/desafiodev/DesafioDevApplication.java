package com.commerce.desafiodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDevApplication.class, args);
	}

}
