package com.example.shopping.review.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReviewUpdateRequest {
    private String content; //리뷰 내용
    private Integer rating; // 평점
    private String reviewImg; //리뷰 사진
}
