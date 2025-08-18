package com.hertz.shoppingMall.statistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsPredictionService {

    private final WebClient webClient;

    public Mono<Map> predictQuantity(String productName, String algo) {
        String encodedProductName = URLEncoder.encode(productName, StandardCharsets.UTF_8);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/predict/product")
                        .queryParam("productName", encodedProductName)
                        .queryParam("algo", algo)
                        .build())
                .retrieve()
                .bodyToMono(Map.class);
    }

}
