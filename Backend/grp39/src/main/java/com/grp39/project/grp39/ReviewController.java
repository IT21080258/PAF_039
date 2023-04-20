package com.grp39.project.grp39;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private static final String idTemplate = "R,%S";    
    private static final String reviewTemplate = "%S";

    @RequestMapping("/review")
    public HttpEntity<Review> review2(
        @RequestParam(value = "_id", defaultValue = "00")String _id, @RequestParam(value = "review", defaultValue = " ")String review ){
            Review  review2 = new Review(String.format(idTemplate, _id), String.format(reviewTemplate, review));
            review2.add(linkTo(methodOn(ReviewController.class).review2(_id,review)).withSelfRel());
            return new ResponseEntity<>(review2, HttpStatus.OK);
        }
}
