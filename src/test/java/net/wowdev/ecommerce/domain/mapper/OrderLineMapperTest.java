package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderLineDTO;
import net.wowdev.ecommerce.domain.dto.ProductDTO;
import net.wowdev.ecommerce.domain.entity.OrderLineEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderLineMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsOrderLineAndDoesNotMapOrderBackReference() {
        ProductDTO product = new ProductDTO(
                ID,
                "Book",
                "A book",
                12.5,
                "BRL",
                "Books",
                NOW,
                NOW);
        OrderLineDTO dto = new OrderLineDTO(
                ID,
                product,
                null,
                2,
                new BigDecimal("12.50"),
                new BigDecimal("25.00"),
                NOW,
                NOW);

        OrderLineEntity entity = OrderLineMapper.toEntity(dto);

        assertEquals(dto, OrderLineMapper.toDto(entity));
        assertNull(entity.getOrder());
    }

    @Test
    void returnsNullForNullOrderLine() {
        assertNull(OrderLineMapper.toEntity(null));
        assertNull(OrderLineMapper.toDto(null));
    }
}
