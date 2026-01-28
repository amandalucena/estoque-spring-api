package com.amanda.estoqueAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EstoqueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApiApplication.class, args);
	}

}
