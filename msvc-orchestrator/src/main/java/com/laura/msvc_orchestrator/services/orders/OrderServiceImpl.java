package com.laura.msvc_orchestrator.services.orders;

import com.laura.msvc_orchestrator.clients.OrdersFeingClient;
import com.laura.msvc_orchestrator.models.orders.OrderDTO;
import com.laura.msvc_orchestrator.models.orders.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrdersFeingClient ordersFeingClient;

    public OrderServiceImpl(OrdersFeingClient ordersFeingClient) {
        this.ordersFeingClient = ordersFeingClient;
    }

    @Override
    public OrderResponse createOrder(OrderDTO orderDTO) {
        return ordersFeingClient.createOrder(orderDTO);
    }

    @Override
    public OrderResponse updateOrder(Long id, String status) {
      return  ordersFeingClient.updateStatusOrder(id, status);
    }
}
