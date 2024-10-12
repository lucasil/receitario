package com.lucassilveira.receitario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages = "com.lucassilveira.receitario")
@EnableJpaRepositories(basePackages = "com.lucassilveira.receitario")
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
public class ReceitarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitarioApplication.class, args);
	}

}
