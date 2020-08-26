package com.cts.micro.OrderService;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.micro.OrderService.entity.Product;

//@FeignClient(name="price-service", url="localhost:8082")

@FeignClient(name = "price-service")
@RibbonClient(name = "price-service")
public interface PriceServiceProxy {

	// http://localhost:8081/api/products/1
	@GetMapping("/api/price/{id}")
	public Product getByProdId(@PathVariable("id") int id);

}
