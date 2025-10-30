package com.laura.msvc_orchestrator.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDTO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("product_id")
    private Integer productId;

    private Integer quantity;

    @JsonProperty("total_amount")
    private Double totalAmount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
