package com.hertz.shoppingMall.utils.log.repository;

import com.hertz.shoppingMall.utils.log.model.AccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessLogRepository extends MongoRepository<AccessLog, String> {
}
