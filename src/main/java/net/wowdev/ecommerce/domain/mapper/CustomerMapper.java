package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.CustomerDTO;
import net.wowdev.ecommerce.domain.entity.CustomerEntity;

public final class CustomerMapper {

    public static CustomerEntity toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        return new CustomerEntity(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getStatus(),
                dto.getBillingAddressId(),
                dto.getShippingAddressId(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static CustomerDTO toDto(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CustomerDTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getStatus(),
                entity.getBillingAddressId(),
                entity.getShippingAddressId(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
