package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.InvoiceDTO;
import net.wowdev.ecommerce.domain.entity.InvoiceEntity;

public final class InvoiceMapper {

    private InvoiceMapper() {
    }

    public static InvoiceEntity toEntity(InvoiceDTO dto) {
        if (dto == null) {
            return null;
        }
        return new InvoiceEntity(
                dto.getId(),
                dto.getTransactionId(),
                dto.getOrderId(),
                dto.getCustomerId(),
                dto.getInvoiceNumber(),
                dto.isDelivered(),
                dto.getDocumentUrl(),
                dto.getDocumentName(),
                null,
                null);
    }

    public static InvoiceDTO toDto(InvoiceEntity entity) {
        if (entity == null) {
            return null;
        }
        return new InvoiceDTO(
                entity.getId(),
                entity.getTransactionId(),
                entity.getOrderId(),
                entity.getCustomerId(),
                entity.getInvoiceNumber(),
                entity.isDelivered(),
                entity.getDocumentUrl(),
                entity.getDocumentName(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
