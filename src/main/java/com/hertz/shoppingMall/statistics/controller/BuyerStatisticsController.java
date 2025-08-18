package com.hertz.shoppingMall.statistics.controller;

import com.hertz.shoppingMall.config.security.CustomUserDetails;
import com.hertz.shoppingMall.product.dto.ProductDto;
import com.hertz.shoppingMall.product.dto.ProductForm;
import com.hertz.shoppingMall.statistics.service.RecommendFacadeService;
import com.hertz.shoppingMall.statistics.service.RecommendInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/buyer/statistics")
@RequiredArgsConstructor
public class BuyerStatisticsController {

    private final RecommendFacadeService recommendFacadeService;

    private final RecommendInfoService recommendInfoService;

    @GetMapping("/recommendations")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> getRecommendations(@AuthenticationPrincipal CustomUserDetails user) {
        if (user == null || !user.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_BUYER"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        List<ProductDto> recommended = recommendFacadeService.getRecommendProducts(user);

        return ResponseEntity.ok(recommended);
    }

    @GetMapping("/highRated")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> highRated() {
        List<ProductDto> highRated = recommendFacadeService.getHighRatedProducts();
        return ResponseEntity.ok(highRated);
    }

    @GetMapping("/trending")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> trending() {
        List<ProductDto> trending = recommendFacadeService.getTrendingProducts();
        return ResponseEntity.ok(trending);
    }

}
