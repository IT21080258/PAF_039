package com.grp39.project.grp39.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.grp39.project.grp39.model.Review;

public interface ReviewRepository extends MongoRepository<Review,String> {
    List<Review> findByUser(String user);
    List<Review> findByRName(String rName);
}
