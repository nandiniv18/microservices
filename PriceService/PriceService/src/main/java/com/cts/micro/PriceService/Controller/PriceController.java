package com.cts.micro.PriceService.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.cts.micro.PriceService.entity.Product;

@RestController
@RequestMapping("/api")
@CrossOrigin
@EnableDiscoveryClient
public class PriceController {
	
	@GetMapping("/1") //TEST URL http://localhost:8082/api/1
	public String temp() {
		return "hiio";
	}

	@GetMapping("/price/{id}")
	public int getPrice(@PathVariable("id") String id) {

		Map<String, String> urivariables = new HashMap<>();
		urivariables.put("id", id);

		ResponseEntity<Product> resEntity = new RestTemplate().getForEntity("http://localhost:8081/api/products/{id}",
				Product.class, urivariables);

		Product prod = resEntity.getBody();

		int price = (int) prod.getPrice();

		return price;
	}

}
