package com.laura.msvc_orchestrator.clients;

import com.laura.msvc_orchestrator.models.orders.OrderDTO;
import com.laura.msvc_orchestrator.models.orders.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-order")
public interface OrdersFeingClient {

    @PostMapping("/api/orders")
    OrderResponse createOrder(@RequestBody OrderDTO order);

    @PutMapping("/api/orders/{id}/{status}")
    OrderResponse updateStatusOrder(@PathVariable Long id, @PathVariable("status") String newStatus);
}
