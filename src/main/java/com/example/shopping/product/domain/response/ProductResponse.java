package com.example.shopping.product.domain.response;

import com.example.shopping.inventory.domain.dto.InventoryDto;
import com.example.shopping.order.domain.dto.HistoryDto;
import com.example.shopping.order.domain.dto.OrderDto;
import com.example.shopping.product.domain.dto.InterestDto;
import com.example.shopping.product.domain.dto.ProductOptionDto;
import com.example.shopping.product.domain.entity.Interest;
import com.example.shopping.product.domain.entity.Product;
import com.example.shopping.product.domain.entity.ProductOption;
import com.example.shopping.review.domain.dto.QuestionAndAnswerDto;
import com.example.shopping.review.domain.dto.ReviewDto;
import com.example.shopping.review.domain.entity.Review;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder

public class ProductResponse {
    private Long productSeq;
    private String name;
    private String imgUrl;
    private String createAt;
    private List<ProductOptionDto> productOptionDto;
    private List<InterestDto> interestDto;
    private List<QuestionAndAnswerDto> questionAndAnswerDto;
    private List<ReviewDto> reviewDto;
    private List<HistoryDto> historyDto;
    private List<OrderDto> orderDto;
    private List<InventoryDto> inventoryDto;

    public ProductResponse(Product product) {
        this.productSeq = product.getProductSeq();
        this.name = product.getName();
        this.imgUrl = product.getImgUrl();
        this.createAt = product.getCreateAt();
        this.productOptionDto = product.getProductOptions() != null ?
                product.getProductOptions().stream().map(ProductOptionDto::new).toList()
                : new ArrayList<>();
//        this.interestDto = product.getInterests() != null ?
//                product.getInterests().stream().map(InterestDto::new).toList()
//                : new ArrayList<>();
        this.questionAndAnswerDto = product.getQuestionAndAnswers() != null ?
                product.getQuestionAndAnswers().stream().map(QuestionAndAnswerDto::new).toList() :
                new ArrayList<>();
        this.reviewDto = product.getReviews() != null ?
                product.getReviews().stream().map(ReviewDto::new).toList() :
                new ArrayList<>();
//        this.historyDto = product.getHistories() != null ?
//                product.getHistories().stream().map(HistoryDto::new).toList() :
//                new ArrayList<>();
        this.orderDto = product.getOrders() != null ?
                product.getOrders().stream().map(OrderDto::new).toList() :
                new ArrayList<>();
        this.inventoryDto = product.getInventories() != null ?
                product.getInventories().stream().map(InventoryDto::new).toList() :
                new ArrayList<>();

    }

}
