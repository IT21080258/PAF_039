package com.grp39.project.grp39.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp39.project.grp39.model.User;
import com.grp39.project.grp39.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repositoryR;

    //Add user
    public User adduser(User user){
        user.set_id(UUID.randomUUID().toString().split("-")[0]);
        return repositoryR.save(user);
    }

    //Get all users
    public List<User> findAllUsers(){
        return repositoryR.findAll();
    }

    //get User by name
    public List<User> getUserByUname(String uname){
        return repositoryR.findByUname(uname);
    } 

    //update user
    public User updateUser(User userRequest){
        User existingUser = repositoryR.findById(userRequest.get_id()).get();
        existingUser.setUname(userRequest.getUname());
        existingUser.setFullname(userRequest.getFullname());
        existingUser.setMobileOREmail(userRequest.getMobileOREmail());
        return repositoryR.save(existingUser);
    }

    //delete user
    public String deleteUser(String userId){
        repositoryR.deleteById(userId);
        return userId+"User Deleted!!!";
    }
}
