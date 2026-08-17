package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.OrderLineDTO;
import net.wowdev.microservice.ecommerce.entity.OrderLineEntity;

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
