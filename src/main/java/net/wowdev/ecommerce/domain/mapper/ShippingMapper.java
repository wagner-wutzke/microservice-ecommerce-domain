package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.ShippingDTO;
import net.wowdev.ecommerce.domain.entity.ShippingEntity;

public final class ShippingMapper {

    private ShippingMapper() {
    }

    public static ShippingEntity toEntity(ShippingDTO dto) {
        if (dto == null) {
            return null;
        }
        return new ShippingEntity(
                dto.getId(),
                OrderMapper.toEntity(dto.getOrder()),
                dto.getShippingStatus(),
                dto.getTrackingNumber(),
                dto.getCarrier(),
                dto.getTrackingUrl(),
                null,
                null);
    }

    public static ShippingDTO toDto(ShippingEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ShippingDTO(
                entity.getId(),
                OrderMapper.toDto(entity.getOrderEntity()),
                entity.getShippingStatus(),
                entity.getTrackingNumber(),
                entity.getCarrier(),
                entity.getTrackingUrl(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
