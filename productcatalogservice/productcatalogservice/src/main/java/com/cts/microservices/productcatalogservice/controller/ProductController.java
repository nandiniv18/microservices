package com.cts.microservices.productcatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservices.productcatalogservice.ProductInventoryServiceProxy;
import com.cts.microservices.productcatalogservice.entity.Product;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
	

	@Autowired
	private ProductInventoryServiceProxy proxy;
	
	@GetMapping("/1") //TEST URL http://localhost:8084/api/1
	public String temp() {
		return "test";
	}
	
	@GetMapping("/listproducts") //http://localhost:8084/api/listproducts
	public String getProductsByFeign(ModelMap map) {
		System.out.println("get products..");
		List<Product> prodLi=  proxy.getAllProducts();
		System.out.println(prodLi);
		map.put("datalist", prodLi);
		System.out.println("got products.."+map.size());
		
		 return "displayProducts";
	}

}
