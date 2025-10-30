package com.laura.msvc_payment.services;

import com.laura.msvc_payment.enums.StatusPayment;
import com.laura.msvc_payment.models.Payment;
import com.laura.msvc_payment.models.PaymentResponse;
import com.laura.msvc_payment.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Double allowedAmount = 1000.0;

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse processPayment(Payment payment) {

        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());
        payment.setTransactionId("TXN-ABCD");

        if (payment.getAmount() > allowedAmount) {
            payment.setErrorMessage("INSUFICIENT_FUNDS");
            payment.setStatus(StatusPayment.FAILED.name());
            paymentRepository.save(payment);
            return PaymentResponse.toPaymentResponse(payment);
        }

        payment.setStatus(StatusPayment.COMPLETED.name());
            paymentRepository.save(payment);

        return PaymentResponse.toPaymentResponse(payment);
    }
}
