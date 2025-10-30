package com.laura.msvc_payment.services;

import com.laura.msvc_payment.models.Payment;
import com.laura.msvc_payment.models.PaymentResponse;

public interface PaymentService {

    PaymentResponse processPayment (Payment payment);

}
