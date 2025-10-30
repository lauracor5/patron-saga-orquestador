package com.laura.msvc_orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ExecuteSagaResponse {

    private Boolean success;

    @JsonProperty("order_id")
    private Long orderId;

    private String message;

    @JsonProperty("payment_id")
    private Long paymentId;

    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("payment_status")
    private String paymentStatus;

    @JsonProperty("error_details")
    private String errorDetails;

    private Double amount;

    @JsonProperty("execution_date")
    private LocalDateTime executionDate;

    public ExecuteSagaResponse(Boolean success, Long orderId, String message, Long paymentId, String orderStatus,
                               String paymentStatus, String errorDetails, Double amount,
                               LocalDateTime executionDate) {
        this.success = success;
        this.orderId = orderId;
        this.message = message;
        this.paymentId = paymentId;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.errorDetails = errorDetails;
        this.amount = amount;
        this.executionDate = executionDate;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDateTime executionDate) {
        this.executionDate = executionDate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
