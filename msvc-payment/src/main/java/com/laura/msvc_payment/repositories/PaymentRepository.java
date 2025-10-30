package com.laura.msvc_payment.repositories;

import com.laura.msvc_payment.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByPaymentId(Long paymentId);

}
