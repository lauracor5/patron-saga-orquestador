package com.laura.msvc_payment.enums;

public enum StatusPayment {

    COMPLETED,
    FAILED,
    REFUNDED;


public static Boolean validateStatus(String newStatus) {

    if (newStatus == null || newStatus.equalsIgnoreCase("")){
        return false;
    }

    for (StatusPayment status: values()) {
        if (status.name().equalsIgnoreCase(newStatus)) {
            return true;
        }
    }
    return false;
    }
}

