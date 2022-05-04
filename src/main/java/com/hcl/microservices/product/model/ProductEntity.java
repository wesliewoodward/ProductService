package com.hcl.microservices.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table("product")
@Getter
@Setter
public class ProductEntity {
	
	@Id
	private Long product_id;
	
	@Column("SKU")
	private String SKU;
	
	@Column("product_name")
	private String product_name;
	
	@Column("description")
	private String description;
	
	@Column("quantity")
	private int quantity;
	
	@Column("regular_price")
	private String regular_price;
	
	@Column("discounted_price")
	private String discounted_price;
	
	@Column("product_rating")
	private String product_rating;
	
	@Column("product_review")
	private String product_review;

}
