package com.grp39.project.grp39.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grp39.project.grp39.model.Comment;

public interface CommentRepository extends MongoRepository<Comment,String> {
    List<Comment> findByReviewID(String reviewID);
}