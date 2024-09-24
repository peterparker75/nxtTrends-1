/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;

import java.util.List;

public interface ReviewRepository {

    List<Review> findByProduct(Product product);

}
