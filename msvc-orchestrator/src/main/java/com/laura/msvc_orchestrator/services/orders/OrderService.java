package com.laura.msvc_orchestrator.services.orders;

import com.laura.msvc_orchestrator.models.orders.OrderDTO;
import com.laura.msvc_orchestrator.models.orders.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderDTO orderDTO);

    OrderResponse updateOrder (Long id, String status);




}
