package com.MAF.ProductAnalyticsApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_analytics")
public class OrderAnalytics {

    @Id
    private String id;

    private Long orderId;
    private Long userId;
    private double totalAmount;

    public OrderAnalytics() {
    }

    public OrderAnalytics(Long orderId, Long userId, double totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}