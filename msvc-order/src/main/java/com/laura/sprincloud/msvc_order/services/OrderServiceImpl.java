package com.laura.sprincloud.msvc_order.services;

import com.laura.sprincloud.msvc_order.enums.StatusOrders;
import com.laura.sprincloud.msvc_order.models.Order;
import com.laura.sprincloud.msvc_order.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {

        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        order.setStatus(StatusOrders.PENDING.name());
        orderRepository.save(order);

        return order;
    }

    @Override
    @Transactional
    public Order updateStatusOrder(Long id, String newStatus) {

        if (!StatusOrders.isValidStatus(newStatus)) {
            throw new IllegalArgumentException("Order status is not valid");
        }

        Order findOrder = getOrder(id);
        findOrder.setStatus(newStatus);
        return orderRepository.save(findOrder);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }
}
