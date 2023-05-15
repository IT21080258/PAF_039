package com.grp39.project.grp39.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Link;

import com.grp39.project.grp39.model.Review;
import com.grp39.project.grp39.service.ReviewService;

@RestController
@RequestMapping("/review/")
public class ReviewController {

    @Autowired
    private ReviewService serviceR;

    public ReviewController(ReviewService reviewService) {
        this.serviceR = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<Review>> createReview(@RequestBody Review review){
        Review createdReview = serviceR.addtask(review);
        Link selfLink = WebMvcLinkBuilder.linkTo(ReviewController.class)
                .slash(createdReview.get_id())
                .withSelfRel();

        EntityModel<Review> reviewModel = EntityModel.of(createdReview);
        reviewModel.add(selfLink);

        return ResponseEntity.ok(reviewModel);
    }

    @GetMapping
    public List<Review> getReviews(){
        return serviceR.findAllReviews();
    }
    
    @GetMapping("/user/{user}")
    public List<Review> findReviewByUser(@PathVariable String user){
        return serviceR.getReviewByUser(user);
    } 

    @GetMapping("/user/{rName}")
    public List<Review> findReviewByRName(@PathVariable String rName){
        return serviceR.getReviewByUser(rName);
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
