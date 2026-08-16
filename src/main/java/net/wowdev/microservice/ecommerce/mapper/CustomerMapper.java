package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.CustomerDTO;
import net.wowdev.microservice.ecommerce.entity.Customer;
import net.wowdev.microservice.ecommerce.entity.CustomerStatus;

public final class CustomerMapper {
    private CustomerMapper() {
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Customer(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getDateOfBirth(),
                CustomerStatus.valueOf(dto.getStatus().name()),
                AddressMapper.toEntity(dto.getBillingAddress()),
                AddressMapper.toEntity(dto.getShippingAddress()),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static CustomerDTO toDto(Customer entity) {
        if (entity == null) {
            return null;
        }
        return CustomerDTO.newBuilder()
                .setId(entity.getId())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setEmail(entity.getEmail())
                .setDateOfBirth(entity.getDateOfBirth())
                .setStatus(net.wowdev.microservice.ecommerce.dto.CustomerStatus.valueOf(
                        entity.getStatus().name()))
                .setBillingAddress(AddressMapper.toDto(entity.getBillingAddress()))
                .setShippingAddress(AddressMapper.toDto(entity.getShippingAddress()))
                .setCreatedAt(entity.getCreatedAt())
                .setModifiedAt(entity.getModifiedAt())
                .build();
    }
}
