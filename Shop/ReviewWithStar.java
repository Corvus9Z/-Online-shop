package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import jakarta.persistence.*;

@Entity
@Table(name="ReviewWithStar")
public class ReviewWithStar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer reviewStarID;

    @Column(name = "Review", nullable = false)
    private String review;
    @Column(name = "NumberOfStars", nullable = false)
    private Integer stars;

    public Integer getReviewStarID() {
        return reviewStarID;
    }

    public void setReviewStarID(Integer reviewStarID) {
        this.reviewStarID = reviewStarID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ReviewWithStar{" +
                "reviewStarID=" + reviewStarID +
                ", review='" + review + '\'' +
                ", stars=" + stars +
                '}';
    }
}
