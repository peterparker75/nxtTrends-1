/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here




package com.example.nxttrendz1.service;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductJpaService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    public List<Product> getAllProducts() {
        return productJpaRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productJpaRepository.save(product);
    }

    public Product getProductById(int productId) {
        return productJpaRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(int productId, Product updatedProduct) {
        Product product = getProductById(productId);
        product.setProductName(updatedProduct.getProductName());
        product.setPrice(updatedProduct.getPrice());
        return productJpaRepository.save(product);
    }

    public void deleteProduct(int productId) {
        productJpaRepository.deleteById(productId);
    }
}
