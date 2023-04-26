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

import com.grp39.project.grp39.model.User;
import com.grp39.project.grp39.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService serviceR;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User creatUser(@RequestBody User user{
        return serviceR.adduser(user);
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
