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

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.service.ReviewJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/reviews")
public class ReviewController {

    @Autowired
    private ReviewJpaService reviewJpaService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewJpaService.getAllReviews();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewJpaService.createReview(review);
    }

    @GetMapping("/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId) {
        return reviewJpaService.getReviewById(reviewId);
    }

    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        return reviewJpaService.updateReview(reviewId, review);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewJpaService.deleteReview(reviewId);
    }
}
