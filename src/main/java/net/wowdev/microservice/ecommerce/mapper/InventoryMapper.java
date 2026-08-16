package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.InventoryDTO;
import net.wowdev.microservice.ecommerce.entity.Inventory;

public final class InventoryMapper {
    private InventoryMapper() {
    }

    public static Inventory toEntity(InventoryDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Inventory(
                dto.getId(),
                ProductMapper.toEntity(dto.getProduct()),
                OrderMapper.toEntity(dto.getOrder()),
                dto.getQuantity(),
                dto.getChangedQuantity(),
                net.wowdev.microservice.ecommerce.entity.InventoryChangeType.valueOf(
                        dto.getChangeType().name()),
                dto.getCreatedAt(),
                null);
    }

    public static InventoryDTO toDto(Inventory entity) {
        if (entity == null) {
            return null;
        }
        return InventoryDTO.newBuilder()
                .setId(entity.getId())
                .setProduct(ProductMapper.toDto(entity.getProduct()))
                .setOrder(OrderMapper.toDto(entity.getOrder()))
                .setQuantity(entity.getQuantity())
                .setChangedQuantity(entity.getChangedQuantity())
                .setChangeType(net.wowdev.microservice.ecommerce.dto.InventoryChangeType.valueOf(
                        entity.getChangeType().name()))
                .setCreatedAt(entity.getCreatedAt())
                .build();
    }
}
