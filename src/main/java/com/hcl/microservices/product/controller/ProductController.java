package com.hcl.microservices.product.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.microservices.product.model.ProductEntity;
import com.hcl.microservices.product.repository.ProductRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	// return all products
	@RequestMapping(value = "/product/all", method=RequestMethod.GET, produces=("application/json"))
	public Flux<ProductEntity> getAll() {
		Flux<ProductEntity> product = repository.findAll();
		return product;
	}
	
	// return products by id
	@RequestMapping(value = "/product/{product_id}", method=RequestMethod.GET, produces=("application/json"))
	public ResponseEntity<Mono<ProductEntity>> getProductById(@PathVariable Long product_id) {
		Mono<ProductEntity> productById = repository.findById(product_id);
		HttpStatus status = productById != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<ProductEntity>>(productById, status);
	}
	
	// return products by category name using inner join from repository
	@RequestMapping(value="/product/by-category/{category_name}", method=RequestMethod.GET, produces=("application/json"))
	public Flux<ProductEntity> findByCategory2(@PathVariable String category_name) {
		Flux<ProductEntity> productsByCategory = repository.findByCategory2(category_name);
		return productsByCategory;
	}
	

}
