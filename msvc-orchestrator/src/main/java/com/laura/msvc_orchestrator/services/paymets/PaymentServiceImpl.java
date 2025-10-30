package com.laura.msvc_orchestrator.services.paymets;

import com.laura.msvc_orchestrator.clients.PaymentFeingClient;
import com.laura.msvc_orchestrator.models.payment.PaymentDTO;
import com.laura.msvc_orchestrator.models.payment.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentFeingClient paymentFeingClient;

    public PaymentServiceImpl(PaymentFeingClient paymentFeingClient) {
        this.paymentFeingClient = paymentFeingClient;
    }

    @Override
    public PaymentResponse processPayment(PaymentDTO paymentDTO) {
        return paymentFeingClient.processPayment(paymentDTO);
    }
}
