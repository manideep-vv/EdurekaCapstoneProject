package com.edureka.controller;

import com.edureka.model.Customer;
import com.edureka.repository.CustomerRepository;
import com.edureka.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerRepository repository;


    @Autowired
    NotificationService svc;

    /**
     * once customer registration is success, this application will call notification service using REST template
     Because once we call http://localhost:8080/api/v1/customers/register it will internally call Notification service using
     http://localhost:8081/api/v1/Notifications/register
     * @param customer
     * @return
     */
    @PostMapping("/register")
    public List<Customer> registerACustomer(@RequestBody Customer customer){
        System.out.println("received Customer details  as "+customer);
        Customer result = repository.save(customer);
        if(!Objects.isNull(result)){
            svc.callNotificationServiceToCreateNotification(result.getId(),"Email",
                    "customer registration is successful with email id "+customer.getEmail());
        }
        System.out.println("customer registration is successful and details are saved in database");
        return repository.findAll();
    }
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

        Optional<Customer> optional = repository.findById(id);
        if(optional.isPresent()){
            Customer customer = optional.get();
            return ResponseEntity.ok(customer);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        // logic
    }
    //worked
//    @PutMapping("/updateCustomer")
//    public ResponseEntity updateCustomerName(@RequestBody Customer customer) {
//        Optional<Customer> existingCustomer = repository.findById(customer.getId());
//        if (existingCustomer.isPresent()) {
//            System.out.println("existing customer is already present,modifying the name");
//            existingCustomer.get().setName(customer.getName());
//            repository.save(existingCustomer.get());
//        }else{
//            System.out.println("no existing customer present");
//            repository.save(customer);
//        }
//        return ResponseEntity.ok().build();
//    }



    //working
    }
