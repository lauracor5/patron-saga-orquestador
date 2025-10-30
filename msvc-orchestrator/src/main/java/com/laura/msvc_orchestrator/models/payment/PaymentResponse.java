package com.laura.msvc_orchestrator.models.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PaymentResponse {

    @JsonProperty("payment_id")
    private Long paymentId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("order_id")
    private Long orderId;

    private Double amount;

    private String status;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("created_at")
    private LocalDateTime createdAtd;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getCreatedAtd() {
        return createdAtd;
    }

    public void setCreatedAtd(LocalDateTime createdAtd) {
        this.createdAtd = createdAtd;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
