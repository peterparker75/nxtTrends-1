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

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewJpaService {

    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    public List<Review> getAllReviews() {
        return reviewJpaRepository.findAll();
    }

    public Review createReview(Review review) {
        return reviewJpaRepository.save(review);
    }

    public Review getReviewById(int reviewId) {
        return reviewJpaRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public Review updateReview(int reviewId, Review updatedReview) {
        Review review = getReviewById(reviewId);
        review.setReviewContent(updatedReview.getReviewContent());
        review.setRating(updatedReview.getRating());
        review.setProduct(updatedReview.getProduct());
        return reviewJpaRepository.save(review);
    }

    public void deleteReview(int reviewId) {
        reviewJpaRepository.deleteById(reviewId);
    }
}
