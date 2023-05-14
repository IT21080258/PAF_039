package com.grp39.project.grp39.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    private String _id;
    private String uname;
    private String fullname;
    private String mobileOREmail;
    private String password;
    


}