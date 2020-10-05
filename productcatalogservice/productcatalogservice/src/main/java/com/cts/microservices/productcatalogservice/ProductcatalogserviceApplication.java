package com.cts.microservices.productcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cts.microservices.productcatalogservice")
public class ProductcatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogserviceApplication.class, args);
	}

}
