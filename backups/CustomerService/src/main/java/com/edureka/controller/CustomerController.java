package com.edureka.controller;

import com.edureka.model.Customer;
import com.edureka.model.Order;
import com.edureka.model.Product;
import com.edureka.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    //working
    @PostMapping("/createCustomer")
    public List<Customer> saveAndGetAllProducts(@RequestBody Customer customer){
        System.out.println("received product as "+customer);
        repository.save(customer);
        return repository.findAll();
    }
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }
    //worked
    @PutMapping("/updateCustomer")
    public ResponseEntity updateCustomerName(@RequestBody Customer customer) {
        Optional<Customer> existingCustomer = repository.findById(customer.getId());
        if (existingCustomer.isPresent()) {
            System.out.println("existing customer is already present,modifying the name");
            existingCustomer.get().setName(customer.getName());
            repository.save(existingCustomer.get());
        }else{
            System.out.println("no existing customer present");
            repository.save(customer);
        }
        return ResponseEntity.ok().build();
    }

    //working
    @DeleteMapping("/deleteCustomer")
public String deleteOrder(@RequestBody Customer customer) {
    System.out.println("deleting customer");
    long initialSize = repository.count();
    repository.deleteById(customer.getId());
    return "initial count is " + initialSize + " Final count is " + repository.count();
}
    }
