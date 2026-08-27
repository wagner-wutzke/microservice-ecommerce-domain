package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.PaymentDTO;
import net.wowdev.ecommerce.domain.entity.PaymentEntity;

public final class PaymentMapper {

    public static PaymentEntity toEntity(PaymentDTO dto) {
        if (dto == null) {
            return null;
        }
        return new PaymentEntity(
                dto.getId(),
                dto.getOrderId(),
                dto.getCustomerId(),
                dto.getTransactionId(),
                dto.getPaymentToken(),
                dto.getAmount(),
                dto.getPaymentMethod(),
                dto.getPaymentStatus(),
                null,
                null);
    }

    public static PaymentDTO toDto(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new PaymentDTO(
                entity.getId(),
                entity.getOrderId(),
                entity.getCustomerId(),
                entity.getTransactionId(),
                entity.getPaymentToken(),
                entity.getPaymentStatus(),
                entity.getAmount(),
                entity.getPaymentMethod(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
