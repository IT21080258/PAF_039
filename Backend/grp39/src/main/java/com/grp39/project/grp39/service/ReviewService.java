package com.grp39.project.grp39.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp39.project.grp39.model.Review;
import com.grp39.project.grp39.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repositoryR;

    //Add review
    public Review addtask(Review review){
        review.set_id(UUID.randomUUID().toString().split("-")[0]);
        return repositoryR.save(review);
    }

    //Get all reviews
    public List<Review> findAllReviews(){
        return repositoryR.findAll();
    }

    //get review by user
    public List<Review> getReviewByUser(String user){
        return repositoryR.findByUser(user);
    } 

    //update review
    public Review updateReview(Review reviewRequest){
        Review existingReview = repositoryR.findById(reviewRequest.get_id()).get();
        existingReview.setReview(reviewRequest.getReview());
        return repositoryR.save(existingReview);
    }

    //delete review
    public String deleteReview(String reviewId){
        repositoryR.deleteById(reviewId);
        return reviewId+"Review Deleted!!!";
    }
}
