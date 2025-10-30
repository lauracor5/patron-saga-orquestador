package com.laura.sprincloud.msvc_order.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_id")
    @JsonProperty("user_id")
    Long userId;

    @Column(name = "product_id")
    @JsonProperty("product_id")
    Integer productId;

    Integer quantity;

    @Column(name = "total_amount")
    @JsonProperty("total_amount")
    Double totalAmount;

    @Column(name = "status", nullable = false)
    String status;

    @JsonProperty("created_at")
    @Column(name = "create_at", nullable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @JsonProperty("updated_at")
    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
