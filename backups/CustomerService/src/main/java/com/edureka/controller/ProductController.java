package com.edureka.controller;

import com.edureka.model.Category;
import com.edureka.model.Order;
import com.edureka.model.Product;
import com.edureka.repository.OrderRepository;
import com.edureka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//@Validated
@Validated
//Tested
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;


    @PostConstruct
    public void init() {
        System.out.println(ProductController.class + " object has been created  ");
    }

    @PostMapping("/createProduct")
    public List<Product> saveAndGetAllProducts(@RequestBody Product product) {
        System.out.println("received product as " + product);
        productRepository.save(product);
        return productRepository.findAll();
    }

    @GetMapping("/getAllProducts")
    public List<Product> GetAllProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/getAllProductsInOrders")
    public Product getAllProductsInAOrder(@RequestBody Order order) {
        Optional<Order> existingOrder = orderRepository.findById(order.getId());
        Long id = existingOrder.get().getProduct().getId();
        return productRepository.findById(id).get();
    }
    @GetMapping("/getAllProductsForACategory")
    public   List<Product> getAllProductsInAOrder(@RequestBody Category category) {
        return productRepository.findAll().stream().filter(p->p.getCategory().getId().equals(category.getId())).collect(Collectors.toList());
    }

    @PutMapping("/updateProduct")
    public List<Product> updateProductNameAndPrice(@RequestBody Product product) {
        Optional<Product> existing = productRepository.findById(product.getId());
        if (existing.isPresent()) {
            System.out.println("product is already present modifying the prod name and price");
            Product existingProduct = existing.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productRepository.save(existingProduct);
        } else {
            productRepository.save(product);
        }
        return productRepository.findAll();
    }

    @DeleteMapping("/deleteProduct")
    public List<Product> deleteProduct(@RequestBody Product product) {
        productRepository.deleteById(product.getId());
        System.out.println("deleting a product with id " + product.getId());
        return productRepository.findAll();
    }
}
