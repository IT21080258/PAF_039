package com.grp39.project.grp39.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.grp39.project.grp39.model.User;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> findByUname(String Uname);
}