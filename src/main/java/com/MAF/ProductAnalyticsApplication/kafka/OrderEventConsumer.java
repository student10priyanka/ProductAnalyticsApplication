package com.MAF.ProductAnalyticsApplication.kafka;

import com.MAF.ProductAnalyticsApplication.event.OrderCreatedEvent;
import com.MAF.ProductAnalyticsApplication.model.OrderAnalytics;
import com.MAF.ProductAnalyticsApplication.repository.OrderAnalyticsRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    private final OrderAnalyticsRepository repository;
    private final MongoTemplate mongoTemplate;

    public OrderEventConsumer(OrderAnalyticsRepository repository,
                              MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @KafkaListener(
            topics = "order-created",
            groupId = "analytics-group"
    )

    public void consumeOrderCreated(OrderCreatedEvent event) {


        System.out.println("===== ORDER EVENT RECEIVED =====");

        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("User ID: " + event.getUserId());
        System.out.println("Total Amount: " + event.getTotalAmount());

        OrderAnalytics analytics = new OrderAnalytics(
                event.getOrderId(),
                event.getUserId(),
                event.getTotalAmount()
        );
        System.out.println("Mongo database: " + mongoTemplate.getDb().getName());
        OrderAnalytics saved = repository.save(analytics);

        System.out.println("Order analytics saved to MongoDB");
        System.out.println("Mongo ID: " + saved.getId());
    }
}