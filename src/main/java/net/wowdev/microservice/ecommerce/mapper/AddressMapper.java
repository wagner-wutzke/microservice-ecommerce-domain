package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.AddressDTO;
import net.wowdev.microservice.ecommerce.entity.Address;

public final class AddressMapper {
    private AddressMapper() {
    }

    public static Address toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Address(
                dto.getId(),
                dto.getAddressLine1(),
                dto.getAddressLine2(),
                dto.getCity(),
                dto.getStateProvince(),
                dto.getPostalCode(),
                dto.getCountry(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static AddressDTO toDto(Address entity) {
        if (entity == null) {
            return null;
        }
        return AddressDTO.newBuilder()
                .setId(entity.getId())
                .setAddressLine1(entity.getAddressLine1())
                .setAddressLine2(entity.getAddressLine2())
                .setCity(entity.getCity())
                .setStateProvince(entity.getStateProvince())
                .setPostalCode(entity.getPostalCode())
                .setCountry(entity.getCountry())
                .setCreatedAt(entity.getCreatedAt())
                .setModifiedAt(entity.getModifiedAt())
                .build();
    }
}
