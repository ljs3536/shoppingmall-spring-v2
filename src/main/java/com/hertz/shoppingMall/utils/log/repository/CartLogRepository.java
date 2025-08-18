package com.hertz.shoppingMall.utils.log.repository;

import com.hertz.shoppingMall.utils.log.model.CartLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartLogRepository extends MongoRepository<CartLog, String> {
}
