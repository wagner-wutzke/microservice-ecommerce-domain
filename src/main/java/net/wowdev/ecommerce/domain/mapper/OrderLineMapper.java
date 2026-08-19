package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderLineDTO;
import net.wowdev.ecommerce.domain.entity.OrderLineEntity;

public final class OrderLineMapper {

    public static OrderLineEntity toEntity(OrderLineDTO dto) {
        if (dto == null) {
            return null;
        }
        return new OrderLineEntity(
                dto.getId(),
                ProductMapper.toEntity(dto.getProduct()),
                null,
                dto.getQuantity(),
                dto.getPrice(),
                dto.getLineAmount(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static OrderLineDTO toDto(OrderLineEntity entity) {
        if (entity == null) {
            return null;
        }
        return new OrderLineDTO(
                entity.getId(),
                ProductMapper.toDto(entity.getProduct()),
                null,
                entity.getQuantity(),
                entity.getPrice(),
                entity.getLineAmount(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
