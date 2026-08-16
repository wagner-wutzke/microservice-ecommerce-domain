package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.PaymentDTO;
import net.wowdev.microservice.ecommerce.entity.Payment;

public final class PaymentMapper {
    private PaymentMapper() {
    }

    public static Payment toEntity(PaymentDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Payment(
                dto.getId(),
                dto.getTransactionId(),
                dto.getAmount(),
                dto.getCurrency(),
                net.wowdev.microservice.ecommerce.entity.PaymentMethod.valueOf(
                        dto.getPaymentMethod().name()),
                net.wowdev.microservice.ecommerce.entity.PaymentStatus.valueOf(
                        dto.getStatus().name()),
                null,
                null);
    }

    public static PaymentDTO toDto(Payment entity) {
        if (entity == null) {
            return null;
        }
        return PaymentDTO.newBuilder()
                .setId(entity.getId())
                .setTransactionId(entity.getTransactionId())
                .setAmount(entity.getAmount())
                .setCurrency(entity.getCurrency())
                .setPaymentMethod(net.wowdev.microservice.ecommerce.dto.PaymentMethod.valueOf(
                        entity.getPaymentMethod().name()))
                .setStatus(net.wowdev.microservice.ecommerce.dto.PaymentStatus.valueOf(
                        entity.getStatus().name()))
                .build();
    }
}
