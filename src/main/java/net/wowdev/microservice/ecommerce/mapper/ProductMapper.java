package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.ProductDTO;
import net.wowdev.microservice.ecommerce.entity.Product;

public final class ProductMapper {
    private ProductMapper() {
    }

    public static Product toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getCurrency(),
                dto.getCategory(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
    }

    public static ProductDTO toDto(Product entity) {
        if (entity == null) {
            return null;
        }
        return ProductDTO.newBuilder()
                .setId(entity.getId())
                .setName(entity.getName())
                .setDescription(entity.getDescription())
                .setUnitPrice(entity.getUnitPrice())
                .setCurrency(entity.getCurrency())
                .setCategory(entity.getCategory())
                .setCreatedAt(entity.getCreatedAt())
                .setModifiedAt(entity.getModifiedAt())
                .build();
    }
}
