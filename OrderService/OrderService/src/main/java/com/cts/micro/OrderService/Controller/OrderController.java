package com.cts.micro.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cts.micro.OrderService.PriceServiceProxy;
import com.cts.micro.OrderService.entity.Product;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {

	@Autowired
	private PriceServiceProxy proxy;
	
	@GetMapping("/ordertest/1") //TEST URL http://localhost:8084/api/1
	public String temp() {
		return "hiio";
	}
	
	
	@GetMapping("/order/{id}")
	public Product getOrder(@PathVariable("id") int id) {
		
		
		return proxy.getByProdId(id);
		
	}

	
}
