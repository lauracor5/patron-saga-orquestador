package com.laura.msvc_orchestrator.models.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDTO {

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("user_id")
    private Long userId;

    private Integer quantity;

    @JsonProperty("product_id")
    private Integer productId;

    private Double amount;

    public PaymentDTO(Long orderId, Long userId, Integer quantity, Integer productId, Double amount) {
        this.orderId = orderId;
        this.userId = userId;
        this.quantity = quantity;
        this.productId = productId;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
