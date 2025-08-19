package com.hertz.shoppingMall.utils.log.model;

import com.hertz.shoppingMall.cart.model.CartItem;
import com.hertz.shoppingMall.member.model.Member;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Document("cart_logs")
public class CartLog {
    @Id
    private String id;

    private Instant timestamp = Instant.now();

    private String actionType;

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


    public static CartLog createCartLog(CartItem item, Member member, String actionType){
        CartLog log = new CartLog();
        log.setUserId(member.getLoginId());
        log.setUserRegion(member.getRegion());
        log.setUserAge(member.getAge());
        log.setUserGender(member.getGender());
        log.setProductName(item.getProduct().getName());
        log.setProductPrice(item.getProduct().getPrice());
        log.setProductQuantity(item.getQuantity());
        log.setActionType(actionType);  // 로그에도 액션 타입 추가
        log.setProductCategory(item.getProduct().getCategory().getName());
        log.setSellerId(item.getProduct().getCreatedBy().getLoginId());
        return log;
    }

}