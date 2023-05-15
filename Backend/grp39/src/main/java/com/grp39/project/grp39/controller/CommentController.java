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

import com.grp39.project.grp39.model.Comment;
import com.grp39.project.grp39.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService serviceR;

    public CommentController(CommentService commentService) {
        this.serviceR = commentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<Comment>> createComment(@RequestBody Comment comment){
        Comment createdComment = serviceR.addtask(comment);
        Link selfLink = WebMvcLinkBuilder.linkTo(CommentController.class)
                .slash(createdComment.get_id())
                .withSelfRel();

        EntityModel<Comment> commentModel = EntityModel.of(createdComment);
        commentModel.add(selfLink);

        return ResponseEntity.ok(commentModel);
    }


    @GetMapping
    public List<Comment> getComments(){
        return serviceR.findAllComments();
    }
    
    @GetMapping("/user/{user}")
    public List<Comment> findCommentByComments(@PathVariable String reviewID){
        return serviceR.getCommentByReview(reviewID);
    } 

    @PutMapping
    public Comment modifyComment(@RequestBody Comment comment){
        return serviceR.updateComment(comment);
    }

    @DeleteMapping("/{CommentId}")
    public String deleteReview(@PathVariable String CommentId){
        serviceR.deleteComment(CommentId);
        return "Successfully deleted comment!!!";
    } 

}


    

