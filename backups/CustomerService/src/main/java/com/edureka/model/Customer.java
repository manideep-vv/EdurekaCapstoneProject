package com.edureka.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany( cascade = CascadeType.ALL)
	private List<Order> orders;

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

	public List<Order> getOrders() {
		return orders;
	}

	public Customer() {
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
