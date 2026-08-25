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
                dto.getTransactionId(),
                dto.getPaymentToken(),
                dto.getAmount(),
                dto.getCurrency(),
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
                entity.getTransactionId(),
                entity.getPaymentToken(),
                entity.getPaymentStatus(),
                entity.getAmount(),
                entity.getCurrency(),
                entity.getPaymentMethod(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
