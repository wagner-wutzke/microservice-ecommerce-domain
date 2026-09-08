package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.ShipmentDTO;
import net.wowdev.ecommerce.domain.entity.ShipmentEntity;

public final class ShipmentMapper {

  public static ShipmentEntity toEntity(ShipmentDTO dto) {
    if (dto == null) {
      return null;
    }
    return new ShipmentEntity(
        dto.getId(),
        dto.getOrderId(),
        dto.getCustomerId(),
        dto.getShippingStatus(),
        dto.getTrackingNumber(),
        dto.getCarrier(),
        dto.getTrackingUrl(),
        null,
        null);
  }

  public static ShipmentDTO toDto(ShipmentEntity entity) {
    if (entity == null) {
      return null;
    }
    return new ShipmentDTO(
        entity.getId(),
        entity.getOrderId(),
        entity.getCustomerId(),
        entity.getShippingStatus(),
        entity.getTrackingNumber(),
        entity.getCarrier(),
        entity.getTrackingUrl(),
        entity.getCreatedAt(),
        entity.getModifiedAt());
  }
}
