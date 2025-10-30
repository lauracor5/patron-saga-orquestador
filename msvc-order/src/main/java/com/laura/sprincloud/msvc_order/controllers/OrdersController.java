package com.laura.sprincloud.msvc_order.controllers;

import com.laura.sprincloud.msvc_order.models.Order;
import com.laura.sprincloud.msvc_order.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @PathVariable String status) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateStatusOrder(id, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(id));
    }
}
