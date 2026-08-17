package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.AddressDTO;
import net.wowdev.microservice.ecommerce.entity.AddressEntity;

public final class AddressMapper {

    public static AddressEntity toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        return new AddressEntity(
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

    public static AddressDTO toDto(AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AddressDTO(
                entity.getId(),
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
