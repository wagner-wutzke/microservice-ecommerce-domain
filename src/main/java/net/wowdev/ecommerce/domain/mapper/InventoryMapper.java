package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.InventoryDTO;
import net.wowdev.ecommerce.domain.entity.InventoryEntity;

public final class InventoryMapper {

    public static InventoryEntity toEntity(InventoryDTO dto) {
        if (dto == null) {
            return null;
        }
        return new InventoryEntity(
                dto.getId(),
                dto.getTransactionId(),
                dto.getProductId(),
                dto.getOrderId(),
                dto.getCurrentQuantity(),
                dto.getChangedQuantity(),
                dto.getPreviousQuantity(),
                dto.getChangeType(),
                dto.getCreatedAt(),
                null);
    }

    public static InventoryDTO toDto(InventoryEntity entity) {
        if (entity == null) {
            return null;
        }
        return new InventoryDTO(
                entity.getId(),
                entity.getTransactionId(),
                entity.getProductId(),
                entity.getOrderId(),
                entity.getCurrentQuantity(),
                entity.getChangedQuantity(),
                entity.getPreviousQuantity(),
                entity.getChangeType(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
