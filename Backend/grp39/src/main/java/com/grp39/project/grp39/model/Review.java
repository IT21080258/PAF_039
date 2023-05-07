package com.grp39.project.grp39.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collation = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    private String _id;
    private String review;
    private String user;


}
