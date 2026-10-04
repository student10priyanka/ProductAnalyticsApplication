package com.MAF.ProductAnalyticsApplication.controller;

import com.MAF.ProductAnalyticsApplication.model.OrderAnalytics;
import com.MAF.ProductAnalyticsApplication.repository.OrderAnalyticsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final OrderAnalyticsRepository repository;

    public AnalyticsController(OrderAnalyticsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    public List<OrderAnalytics> getAllOrders() {
        return repository.findAll();
    }
}