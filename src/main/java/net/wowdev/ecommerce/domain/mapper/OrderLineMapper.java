package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderLineDTO;
import net.wowdev.ecommerce.domain.entity.OrderEntity;
import net.wowdev.ecommerce.domain.entity.OrderLineEntity;

public final class OrderLineMapper {

    public static OrderLineEntity toEntity(OrderLineDTO dto) {
        if (dto == null) {
            return null;
        }
        return new OrderLineEntity(
                dto.getId(),
                dto.getProductId(),
                dto.getOrderId(),
                dto.getQuantity(),
                dto.getPrice(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static OrderLineDTO toDto(OrderLineEntity entity) {
        if (entity == null) {
            return null;
        }
        return new OrderLineDTO(
                entity.getId(),
                entity.getOrderId(),
                entity.getProductId(),
                entity.getQuantity(),
                entity.getPrice(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
