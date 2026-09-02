package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.PaymentMethodDTO;
import net.wowdev.ecommerce.domain.entity.PaymentMethodEntity;

public final class PaymentMethodMapper {

  public static PaymentMethodEntity toEntity(PaymentMethodDTO dto) {
    if (dto == null) {
      return null;
    }
    return new PaymentMethodEntity(
        dto.getId(),
        dto.getCustomerId(),
        dto.getCardNumber(),
        dto.getOwnerName(),
        dto.getExpiration(),
        dto.getCvv(),
        dto.getCardName(),
        null,
        null);
  }

  public static PaymentMethodDTO toDto(PaymentMethodEntity entity) {
    if (entity == null) {
      return null;
    }
    return new PaymentMethodDTO(
        entity.getId(),
        entity.getCustomerId(),
        entity.getCardNumber(),
        entity.getOwnerName(),
        entity.getExpiration(),
        entity.getCvv(),
        entity.getCardName(),
        entity.getCreatedAt(),
        entity.getModifiedAt());
  }
}
