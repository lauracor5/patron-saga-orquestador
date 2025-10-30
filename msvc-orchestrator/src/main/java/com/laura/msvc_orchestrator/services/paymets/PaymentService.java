package com.laura.msvc_orchestrator.services.paymets;

import com.laura.msvc_orchestrator.models.payment.PaymentDTO;
import com.laura.msvc_orchestrator.models.payment.PaymentResponse;

public interface PaymentService {

    PaymentResponse processPayment (PaymentDTO paymentDTO);
}
