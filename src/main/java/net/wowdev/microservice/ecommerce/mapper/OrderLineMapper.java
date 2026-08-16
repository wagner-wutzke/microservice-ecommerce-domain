package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.OrderLineDTO;
import net.wowdev.microservice.ecommerce.entity.OrderLine;

public final class OrderLineMapper {
    private OrderLineMapper() {
    }

    public static OrderLine toEntity(OrderLineDTO dto) {
        if (dto == null) {
            return null;
        }
        return new OrderLine(
                dto.getId(),
                ProductMapper.toEntity(dto.getProduct()),
                null,
                dto.getQuantity(),
                dto.getPrice(),
                dto.getLineAmount(),
                null,
                null);
    }

    public static OrderLineDTO toDto(OrderLine entity) {
        if (entity == null) {
            return null;
        }
        return OrderLineDTO.newBuilder()
                .setId(entity.getId())
                .setProduct(ProductMapper.toDto(entity.getProduct()))
                .setQuantity(entity.getQuantity())
                .setPrice(entity.getPrice())
                .setLineAmount(entity.getLineAmount())
                .build();
    }
}
