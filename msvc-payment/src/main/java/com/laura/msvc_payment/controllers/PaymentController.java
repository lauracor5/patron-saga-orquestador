package com.laura.msvc_payment.controllers;

import com.laura.msvc_payment.models.Payment;
import com.laura.msvc_payment.models.PaymentResponse;
import com.laura.msvc_payment.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments/process")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody Payment payment) {
        PaymentResponse paymentResponse = paymentService.processPayment(payment);
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponse);
    }
}
