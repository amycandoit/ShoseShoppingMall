package com.example.shopping.review.domain.Response;

import com.example.shopping.review.domain.entity.Review;
import lombok.Getter;

@Getter
public class ReviewResponse {
    private String content;
    private Integer rating;
    private String reviewImg;

    public ReviewResponse(Review review) {
        this.content = review.getContent();
        this.rating = review.getRating();
        this.reviewImg = review.getReviewImg();
    }
}
