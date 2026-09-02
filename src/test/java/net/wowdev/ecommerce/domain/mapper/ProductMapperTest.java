package net.wowdev.ecommerce.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.ProductDTO;
import net.wowdev.ecommerce.domain.entity.ProductEntity;
import org.junit.jupiter.api.Test;

class ProductMapperTest {
  private static final UUID ID = UUID.randomUUID();
  private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

  @Test
  void mapsProductBothWays() {
    ProductDTO dto =
        new ProductDTO(ID, "Book", "A book",
            BigDecimal.valueOf(12.5), "Books", NOW, NOW);

    ProductEntity entity = ProductMapper.toEntity(dto);

    assertEquals(dto, ProductMapper.toDto(entity));
  }

  @Test
  void returnsNullForNullProduct() {
    assertNull(ProductMapper.toEntity(null));
    assertNull(ProductMapper.toDto(null));
  }
}
