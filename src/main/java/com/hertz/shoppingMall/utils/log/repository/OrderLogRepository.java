package com.hertz.shoppingMall.utils.log.repository;

import com.hertz.shoppingMall.utils.log.model.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLogRepository extends MongoRepository<OrderLog,String> {
}
