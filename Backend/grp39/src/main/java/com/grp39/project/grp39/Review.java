package com.grp39.project.grp39;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Review extends RepresentationModel<Review>{
    private final String _id;
    private final String review;

    @JsonCreator
    public Review (@JsonProperty("_id") String _id, @JsonProperty("review") String review){
        this._id = _id;
        this.review = review;
    }

    public String getid (){
        return _id;
    }
    public String getreview (){
        return review;
    }

}
