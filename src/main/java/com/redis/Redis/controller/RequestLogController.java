package com.redis.Redis.controller;

import com.redis.Redis.model.RequestLog;
import com.redis.Redis.repository.RequestLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class RequestLogController {


    @Autowired
    private RequestLogRepository repository;

    @GetMapping(value = "/request/{requestId}")
    public ResponseEntity<RequestLog> getRequest(@PathVariable("requestId") String requestId) {
        return new ResponseEntity<>(repository.findItemById(requestId), HttpStatus.OK);
    }

    @PostMapping(value = "/request")
    public ResponseEntity<RequestLog> createRequest(@RequestBody RequestLog requestLog) {
        return new ResponseEntity<>(repository.save(requestLog), HttpStatus.OK);
    }

}
