package com.grp39.project.grp39.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.grp39.project.grp39.model.User;
import com.grp39.project.grp39.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService serviceR;

    public UserController(UserService userService) {
        this.serviceR = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<User>> createUser(@RequestBody User user){
        User createdUser = serviceR.adduser(user);
        Link selfLink = WebMvcLinkBuilder.linkTo(ReviewController.class)
                .slash(createdUser.get_id())
                .withSelfRel();

        EntityModel<User> reviewUser = EntityModel.of(createdUser);
        reviewUser.add(selfLink);

        return ResponseEntity.ok(reviewUser);
    }


    @GetMapping
    public List<User> getUsers(){
        return serviceR.findAllUsers();
    }
    
    @GetMapping("/uname/{uname}")
    public List<User> findReviewByUname(@PathVariable String uname){
        return serviceR.getUserByUname(uname);
    } 

    @PutMapping
    public User modifyReview(@RequestBody User user){
        
        return serviceR.updateUser(user);
    }

    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable String userID){
        serviceR.deleteUser(userID);
        return "Successfully deleted User!!";
    } 

}
