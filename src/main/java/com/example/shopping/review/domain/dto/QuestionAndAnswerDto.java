package com.example.shopping.review.domain.dto;

import com.example.shopping.review.domain.entity.QuestionAndAnswer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionAndAnswerDto {
    private Long qaSeq;
    private String title; //질문 제목
    private String content; //질문 내용
    private String answer; //답변
    private String name;
//    private Long productSeq;

    public QuestionAndAnswerDto(QuestionAndAnswer questionAndAnswer) {
        this.qaSeq = questionAndAnswer.getQaSeq();
        this.title = questionAndAnswer.getTitle();
        this.content = questionAndAnswer.getContent();
        this.answer = questionAndAnswer.getAnswer();
        this.name = questionAndAnswer.getMember().getId();
//        this.productSeq = questionAndAnswer.getProduct().getProductSeq();
    }
}
