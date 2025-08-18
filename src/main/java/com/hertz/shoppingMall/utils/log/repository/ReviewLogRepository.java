package com.hertz.shoppingMall.utils.log.repository;

import com.hertz.shoppingMall.utils.log.model.ReviewLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewLogRepository extends MongoRepository<ReviewLog,String> {
}
