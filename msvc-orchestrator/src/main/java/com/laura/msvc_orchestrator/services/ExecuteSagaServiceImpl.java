package com.laura.msvc_orchestrator.services;

import com.laura.msvc_orchestrator.enums.StatusOrders;
import com.laura.msvc_orchestrator.enums.StatusPayment;
import com.laura.msvc_orchestrator.models.ExecuteSagaResponse;
import com.laura.msvc_orchestrator.models.orders.OrderDTO;
import com.laura.msvc_orchestrator.models.orders.OrderResponse;
import com.laura.msvc_orchestrator.models.payment.PaymentDTO;
import com.laura.msvc_orchestrator.models.payment.PaymentResponse;
import com.laura.msvc_orchestrator.services.orders.OrderService;
import com.laura.msvc_orchestrator.services.paymets.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExecuteSagaServiceImpl implements ExecuteSagaService {

    private final OrderService orderService;

    private final PaymentService paymentService;

    public ExecuteSagaServiceImpl(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @Override
    public ExecuteSagaResponse executionProcessSaga(OrderDTO orderDTO) {

        OrderResponse orderResponse = orderService.createOrder(orderDTO);
        System.out.println("Order created");

        PaymentDTO paymentRequest = new PaymentDTO(
                orderResponse.getId(),
                orderDTO.getUserId(),
                orderDTO.getQuantity(),
                orderDTO.getProductId(),
                orderDTO.getTotalAmount()
        );

        PaymentResponse paymentResponse =  paymentService.processPayment(paymentRequest);

        OrderResponse orderUpdatedProcessed;
        if (!StatusPayment.COMPLETED.name().equalsIgnoreCase(paymentResponse.getStatus())) {
            orderUpdatedProcessed = orderService.updateOrder(paymentResponse.getOrderId(), StatusOrders.CANCELLED.name());
            return builderResponseProcessExecutionError(orderUpdatedProcessed, paymentResponse);
        }

        orderUpdatedProcessed = orderService.updateOrder(paymentResponse.getOrderId(), StatusOrders.PROCESSED.name());
        return builderResponseProcessExecutionOk(orderUpdatedProcessed, paymentResponse);
    }

    private ExecuteSagaResponse builderResponseProcessExecutionError (OrderResponse orderResponse,
                                                                      PaymentResponse paymentResponse){

            return  new ExecuteSagaResponse(
                    false,
                    paymentResponse.getOrderId(),
                    "",
                    paymentResponse.getPaymentId(),
                    orderResponse.getStatus(),
                    paymentResponse.getStatus(),
                    "",
                    paymentResponse.getAmount(),
                    LocalDateTime.now());

        }

    private ExecuteSagaResponse builderResponseProcessExecutionOk (OrderResponse orderResponse,
                                                                   PaymentResponse paymentResponse){

        return  new ExecuteSagaResponse(
                true,
                paymentResponse.getOrderId(),
                "",
                paymentResponse.getPaymentId(),
                orderResponse.getStatus(),
                paymentResponse.getStatus(),
                "",
                paymentResponse.getAmount(),
                LocalDateTime.now());

    }

    }

