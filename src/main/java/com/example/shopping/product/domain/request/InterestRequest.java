package com.example.shopping.product.domain.request;

import com.example.shopping.member.domain.entity.Member;
import com.example.shopping.product.domain.entity.Interest;
import com.example.shopping.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestRequest {
    private LocalDate interestDate;
    private Integer interestLike;

    public Interest toEntity(Long productSeq,Long memberSeq) {
        return Interest.builder()
                .interestDate(interestDate)
                .interestLike(interestLike)
                .product(Product.builder().productSeq(productSeq).build())
                .member(Member.builder().memberSeq(memberSeq).build())
                .build();
    }

}
