package com.edureka.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotBlank(message = "Category name is mandatory")
//	@Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")
	private String name;

	@OneToMany(mappedBy = "category")
	List<Product> products;

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

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}
}

