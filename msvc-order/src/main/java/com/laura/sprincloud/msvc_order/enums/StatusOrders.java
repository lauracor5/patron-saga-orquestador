package com.laura.sprincloud.msvc_order.enums;

public enum StatusOrders {

    PENDING,

    PROCESSED,

    CANCELLED;


    public static boolean isValidStatus(String statusFind) {

        if (statusFind == null || statusFind.equalsIgnoreCase("")) {
            return false;
        }

        for (StatusOrders status: values()) {
            if (status.name().equalsIgnoreCase(statusFind)) {
                return  true;
            }
        }

        return false;
    }
}
