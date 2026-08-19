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
                dto.getDateOfBirth(),
                dto.getStatus(),
                AddressMapper.toEntity(dto.getBillingAddress()),
                AddressMapper.toEntity(dto.getShippingAddress()),
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
                entity.getDateOfBirth(),
                entity.getStatus(),
                AddressMapper.toDto(entity.getBillingAddressEntity()),
                AddressMapper.toDto(entity.getShippingAddressEntity()),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
