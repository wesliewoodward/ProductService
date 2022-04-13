package com.hcl.microservices.product.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.microservices.product.model.ProductEntity;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
	
	@Query("SELECT * FROM product p "
			+ "INNER JOIN category c "
			+ "ON p.product_id = c.product_id "
			+ "WHERE c.category_name=:category_name")
	Flux<ProductEntity> findByCategory(@Param("category_name") String category_name);

}
