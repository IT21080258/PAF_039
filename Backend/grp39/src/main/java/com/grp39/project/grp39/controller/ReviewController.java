package com.grp39.project.grp39.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grp39.project.grp39.model.Review;
import com.grp39.project.grp39.service.ReviewService;

@RestController
@RequestMapping("/review/")
public class ReviewController {

    @Autowired
    private ReviewService serviceR;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review creatReview(@RequestBody Review review){
        return serviceR.addtask(review);
    }

    @GetMapping
    public List<Review> getReviews(){
        return serviceR.findAllReviews();
    }
    
    @GetMapping("/user/{user}")
    public List<Review> findReviewByUser(@PathVariable String user){
        return serviceR.getReviewByUser(user);
    } 

    @PutMapping
    public Review modifyReview(@RequestBody Review review){
        return serviceR.updateReview(review);
    }

    @DeleteMapping("/{reviewID}")
    public String deleteReview(@PathVariable String reviewID){
        serviceR.deleteReview(reviewID);
        return "Successfully deleted review!!!";
    } 

}
