package com.example.spring.model.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int value;

    public static OrderStatus valueOf(int value) {
        for (OrderStatus os : OrderStatus.values()) {
            if (os.getValue() == value) {
                return os;
            }
        }

        throw new IllegalArgumentException("Invalid OrderStatus value");
    }
}
