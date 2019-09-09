package com.example.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingBook implements Comparable<RatingBook> {

    private String author;
    private Double averageRating;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public int compareTo(RatingBook o) {
        return o.getAverageRating().compareTo(this.averageRating);
    }
}
