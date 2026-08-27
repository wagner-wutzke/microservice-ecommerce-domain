package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.ProductDTO;
import net.wowdev.ecommerce.domain.entity.ProductEntity;

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
                entity.getCategory(),
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
