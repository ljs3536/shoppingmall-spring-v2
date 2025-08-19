package com.hertz.shoppingMall.utils.log.model;

import com.hertz.shoppingMall.review.model.Review;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Document("review_logs")
public class ReviewLog {
    @Id
    private String id;

    private Instant timestamp = Instant.now();

    // 유저 정보
    private String userId;
    private Integer userAge;
    private String userRegion;
    private String userGender;

    // 상품 정보
    private String productName;
    private Integer productPrice;
    private Integer productQuantity;
    private String productDescription;
    private String productCategory;
    private String sellerId;

    // 리뷰 정보
    private Integer rating;
    private String description;


    public static ReviewLog createReviewLog(Review review) {
        ReviewLog log = new ReviewLog();
        log.setUserId(review.getMember().getLoginId());
        log.setUserRegion(review.getMember().getRegion());
        log.setUserAge(review.getMember().getAge());
        log.setUserGender(review.getMember().getGender());
        log.setProductName(review.getProduct().getName());
        log.setProductPrice(review.getProduct().getPrice());
        log.setProductQuantity(review.getOrderItem().getQuantity());
        log.setProductCategory(review.getProduct().getCategory().getName());
        log.setSellerId(review.getProduct().getCreatedBy().getLoginId());
        log.setRating(review.getRating());
        log.setDescription(review.getContent());
        return log;
    }
}
