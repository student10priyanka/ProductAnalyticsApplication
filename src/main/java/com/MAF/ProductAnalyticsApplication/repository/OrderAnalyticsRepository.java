package com.MAF.ProductAnalyticsApplication.repository;


import com.MAF.ProductAnalyticsApplication.model.OrderAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderAnalyticsRepository
        extends MongoRepository<OrderAnalytics, String> {
}