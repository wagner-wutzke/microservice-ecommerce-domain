package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.ProductDTO;
import net.wowdev.microservice.ecommerce.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsProductBothWays() {
        ProductDTO dto = new ProductDTO(ID, "Book", "A book", 12.5, "BRL", "Books", NOW, NOW);

        ProductEntity entity = ProductMapper.toEntity(dto);

        assertEquals(dto, ProductMapper.toDto(entity));
    }

    @Test
    void returnsNullForNullProduct() {
        assertNull(ProductMapper.toEntity(null));
        assertNull(ProductMapper.toDto(null));
    }
}
