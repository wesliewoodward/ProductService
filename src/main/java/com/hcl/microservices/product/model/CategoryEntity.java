package com.hcl.microservices.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table("category")
@Getter
@Setter
public class CategoryEntity {
	
	@Id
	private Long category_id;
	
	@Column
	private Long product_id;
	
	@Column("category_name")
	private String category_name;
	
//	@Column("date_posted")
//	private String date_posted;

}
