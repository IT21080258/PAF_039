package com.grp39.project.grp39.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comment{
    @Id
    private String _id;
    private String reviewID;
    private String user;
    private String comment;


}