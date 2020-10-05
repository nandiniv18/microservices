package com.cts.microservices.productcatalogservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.microservices.productcatalogservice.entity.Product;

@FeignClient(name = "Product-Inventory-Service", url="localhost:8081")
public interface ProductInventoryServiceProxy { 
		@GetMapping("/api/products")
		public List<Product> getAllProducts() ;

}
