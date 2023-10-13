package com.edureka.controller;

import com.edureka.model.Customer;
import com.edureka.model.Order;
import com.edureka.repository.CustomerRepository;
import com.edureka.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    //working
    @PostMapping("/createOrder")
    public String saveAndGetAllProducts(@RequestBody Order order) {
        long initialSize = repository.count();
        System.out.println("received order as " + order);
        repository.save(order);
        return "initial count is " + initialSize + " Final count is " + repository.count();

    }

    //This is also working
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return repository.findAll();
    }


    //working
    @PutMapping("/updateOrder")
//this will update only quantity
    public ResponseEntity updateOrder(@RequestBody Order order) {
        Optional<Order> existingOrder = repository.findById(order.getId());
        if (existingOrder.isPresent()) {
            System.out.println("existing order is already present");
            existingOrder.get().setQuantity(order.getQuantity());
            repository.save(existingOrder.get());
        } else {
            repository.save(order);
        }
        return ResponseEntity.ok().build();
    }

    //working
    @DeleteMapping("/deleteOrder")
    public String deleteOrder(@RequestBody Order order) {
        System.out.println("deleting order");
        long initialSize = repository.count();
        repository.deleteById(order.getId());
        return "initial count is " + initialSize + " Final count is " + repository.count();
    }
}
