package com.hertz.shoppingMall.utils.log.model;

import com.hertz.shoppingMall.member.model.Member;
import com.hertz.shoppingMall.order.model.OrderItem;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Document("order_products-logs")
public class OrderLog {
    @Id
    private String id;
    private Instant timestamp = Instant.now();

    private String orderType;

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

    public static OrderLog createOrderLog(Member member, OrderItem item, String orderType){
        OrderLog log = new OrderLog();
        log.setOrderType(orderType);
        log.setUserId(member.getLoginId());
        log.setUserRegion(member.getRegion());
        log.setUserAge(member.getAge());
        log.setUserGender(member.getGender());
        log.setProductName(item.getProduct().getName());
        log.setProductPrice(item.getProduct().getPrice());
        log.setProductDescription(item.getProduct().getDescription());
        log.setProductQuantity(item.getQuantity());
        log.setProductCategory(item.getProduct().getCategory().getName());
        log.setSellerId(item.getProduct().getCreatedBy().getLoginId());
        return log;
    }
}
