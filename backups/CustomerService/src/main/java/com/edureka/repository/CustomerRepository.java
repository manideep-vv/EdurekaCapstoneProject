package com.edureka.repository;

import com.edureka.model.Customer;
import com.edureka.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
