package com.laura.msvc_orchestrator.clients;

import com.laura.msvc_orchestrator.models.payment.PaymentDTO;
import com.laura.msvc_orchestrator.models.payment.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "msvc-payment")
public interface PaymentFeingClient {

    @PostMapping("/api/payments/process")
    PaymentResponse processPayment (PaymentDTO paymentDTO);


}
