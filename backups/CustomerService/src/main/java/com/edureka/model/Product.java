package com.edureka.model;

import javax.persistence.*;

@Entity
public class Product {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Double price;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * Needs change
	 * @return Boolean
	 */
	public Boolean isInStock() {
		return true;
	}

	public Product(String name, Double price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Product() {
	}
}
