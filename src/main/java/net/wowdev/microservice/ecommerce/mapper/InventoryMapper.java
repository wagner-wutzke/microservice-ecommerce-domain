package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.InventoryDTO;
import net.wowdev.microservice.ecommerce.entity.InventoryEntity;

public final class InventoryMapper {

    public static InventoryEntity toEntity(InventoryDTO dto) {
        if (dto == null) {
            return null;
        }
        return new InventoryEntity(
                dto.getId(),
                ProductMapper.toEntity(dto.getProduct()),
                OrderMapper.toEntity(dto.getOrder()),
                dto.getQuantity(),
                dto.getChangedQuantity(),
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
                ProductMapper.toDto(entity.getProductEntity()),
                OrderMapper.toDto(entity.getOrderEntity()),
                entity.getQuantity(),
                entity.getChangedQuantity(),
                entity.getChangeType(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
