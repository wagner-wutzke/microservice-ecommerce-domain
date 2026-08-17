package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.ProductDTO;
import net.wowdev.microservice.ecommerce.entity.ProductEntity;

public final class ProductMapper {

    public static ProductEntity toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        return new ProductEntity(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getCurrency(),
                dto.getCategory(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static ProductDTO toDto(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getCurrency(),
                entity.getCategory(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
