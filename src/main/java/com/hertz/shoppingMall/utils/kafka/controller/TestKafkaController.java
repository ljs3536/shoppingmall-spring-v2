package com.hertz.shoppingMall.utils.kafka.controller;

import com.hertz.shoppingMall.utils.kafka.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestKafkaController {

    private final KafkaProducerService kafkaProducer;

    @GetMapping("/test/kafka")
    public String testKafka(@RequestParam("msg") String msg) {
        kafkaProducer.sendMessage("user-activity", msg);
        return "Sent: " + msg;
    }
}