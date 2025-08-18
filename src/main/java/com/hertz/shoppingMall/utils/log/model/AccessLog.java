package com.hertz.shoppingMall.utils.log.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Document("access-logs")
public class AccessLog {
    @Id
    private String id;

    private Instant timestamp = Instant.now();

    private String path;

    private String method;

    private long executionTime;

    private String userId;

    private String userAgent;

    private String ipAddress;

}