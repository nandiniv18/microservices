package com.cts.springboot.productinventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.springboot.productinventoryservice.entity.Product;
import com.cts.springboot.productinventoryservice.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private  ProductService productservice;
	
	@Autowired
	CacheManager cacheManager;
	
	@GetMapping("/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping("/price/{id}")
	public double getPrice(@PathVariable("id") int id) {
		Product product = productservice.findPrice(id);
		return product.getPrice();
	}
	
	@Scheduled(fixedRate = 1800000)
	public void evictAllcachesAtIntervals() {
	    evictAllCaches();
	}
	
	public void evictAllCaches() {
		 System.out.println("Evicting Cache...");
	    cacheManager.getCacheNames().stream()
	      .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		System.out.println("inside Main service");
		return productservice.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getByProdId(@PathVariable("id") int id) {
		return productservice.findById(id);
	}
	
	@PostMapping("/products")
	public Product postProducts(@RequestBody Product product) {
		return productservice.saveProduct(product);
	}
	
	@PostMapping("/products/all")
	public List<Product> postProductAll(@RequestBody List<Product> product) {
		return productservice.saveProduct(product);
	}
	
	@GetMapping("/deleteproduct/{id}")
	public Product deleteByProdId(@PathVariable("id") int id) {
		return productservice.deleteById(id);
	}
	@GetMapping("/promo/{id}")
	public ResponseEntity<?> getByProdOnPromotion(@PathVariable("id") int id) {
		
		System.out.println("inside promo..");
		
		Product prod =  productservice.findById(id);
		
		if(prod.getOffer() != "Y")
		    return new ResponseEntity<>(prod, HttpStatus.OK);
		else
			System.out.println("On offer..");
		    return new ResponseEntity<>(prod, HttpStatus.valueOf(302));

		}
	
}
