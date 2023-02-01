package com.redis.Redis.repository;

import com.redis.Redis.model.RequestLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class RequestLogRepository {

    private static final String REQUEST_KEY_NAME = "REQUEST_LOG";

    @Autowired
    private RedisTemplate redisTemplate;

    public RequestLog save(RequestLog requestLog) {
        log.info("Request log save() method : {}", requestLog.getId());
        redisTemplate.opsForHash().put(REQUEST_KEY_NAME, requestLog.getId(), requestLog);
        log.info("Successfully saved : {}", requestLog.getId());
        return requestLog;
    }

    public RequestLog findItemById(String id) {
        log.info("Request log findItemById() method : {}", id);
        RequestLog request = (RequestLog) redisTemplate.opsForHash().get(REQUEST_KEY_NAME, id);
        log.info("Request log findItemById() response : {}", request);
        return request;
    }

}
