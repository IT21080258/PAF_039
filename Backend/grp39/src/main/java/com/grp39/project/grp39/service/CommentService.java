package com.grp39.project.grp39.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp39.project.grp39.model.Comment;
import com.grp39.project.grp39.repository.CommentRepository;


@Service
public class CommentService {

    // private static final Object Comment = null;
    @Autowired
    private CommentRepository repositoryR;

    //Add review
    public Comment addtask(Comment comment){
        comment.set_id(UUID.randomUUID().toString().split("-")[0]);
        return repositoryR.save(comment);
    }

    //Get all reviews
    public List<Comment> findAllComments(){
        return repositoryR.findAll();
    }

    //get review by user
    public List<Comment> getCommentByReview(String reviewID){
        return repositoryR.findByReviewID(reviewID);
    } 

    //update review
    public Comment updateComment(Comment commentRequest){
        Comment existingComment = repositoryR.findById(commentRequest.get_id()).get();
        existingComment.setComment(commentRequest.getComment());
        return repositoryR.save(existingComment);
    }

    //delete review
    public String deleteComment(String CommentId){
        repositoryR.deleteById(CommentId);
        return CommentId+"Comment Deleted!!!";
    }
}
