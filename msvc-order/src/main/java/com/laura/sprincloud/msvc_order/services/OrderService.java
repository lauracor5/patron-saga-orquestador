package com.laura.sprincloud.msvc_order.services;

import com.laura.sprincloud.msvc_order.models.Order;

import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);

    Order updateStatusOrder(Long id, String newStatus);

    Order getOrder(Long id);
}
