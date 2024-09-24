/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here




package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductJpaService productJpaService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productJpaService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productJpaService.createProduct(product);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productJpaService.getProductById(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        return productJpaService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productJpaService.deleteProduct(productId);
    }
}
