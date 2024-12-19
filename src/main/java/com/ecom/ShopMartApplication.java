package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages ="com.ecom.model")
@EnableAutoConfiguration
public class ShopMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMartApplication.class, args);
	}

}
