package net.wowdev.ecommerce.domain.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.wowdev.ecommerce.domain.dto.CustomerDTO;
import net.wowdev.ecommerce.domain.dto.PaymentMethodDTO;
import net.wowdev.ecommerce.domain.entity.CustomerEntity;
import net.wowdev.ecommerce.domain.entity.PaymentMethodEntity;

public final class CustomerMapper {

  public static CustomerEntity toEntity(CustomerDTO dto) {
    if (dto == null) {
      return null;
    }

    List<PaymentMethodEntity> paymentMethodEntities =
        dto.getPaymentMethods().stream()
            .filter(Objects::nonNull)
            .map(PaymentMethodMapper::toEntity)
            .toList();

    return new CustomerEntity(
        dto.getId(),
        dto.getFirstName(),
        dto.getLastName(),
        dto.getEmail(),
        dto.getCustomerStatus(),
        paymentMethodEntities,
        dto.getAddressLine1(),
        dto.getAddressLine2(),
        dto.getCity(),
        dto.getStateProvince(),
        dto.getPostalCode(),
        dto.getCountry(),
        dto.getCreatedAt(),
        dto.getModifiedAt());
  }

  public static CustomerDTO toDto(CustomerEntity entity) {
    if (entity == null) {
      return null;
    }

    List<PaymentMethodDTO> paymentMethodDTOs =
        entity.getPaymentMethods().stream()
            .filter(Objects::nonNull)
            .map(PaymentMethodMapper::toDto)
            .collect(Collectors.toList());

    return new CustomerDTO(
        entity.getId(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getEmail(),
        entity.getCustomerStatus(),
        paymentMethodDTOs,
        entity.getAddressLine1(),
        entity.getAddressLine2(),
        entity.getCity(),
        entity.getStateProvince(),
        entity.getPostalCode(),
        entity.getCountry(),
        entity.getCreatedAt(),
        entity.getModifiedAt());
  }
}
