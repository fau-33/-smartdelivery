package br.com.javadevweek.smartdelivery.modules.orders.dto;

import java.util.UUID;

public record CreateOrderResponse(UUID orderid, String status) {
}
