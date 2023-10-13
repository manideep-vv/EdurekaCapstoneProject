package com.edureka.repository;

import com.edureka.model.Customer;
import com.edureka.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
