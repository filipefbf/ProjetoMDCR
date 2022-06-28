package com.application.creditorural;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class CreditoRuralApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditoRuralApplication.class, args);
	}


}
