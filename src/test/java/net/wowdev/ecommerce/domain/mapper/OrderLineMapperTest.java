package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderLineDTO;
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
    void canInstantiateMapper() {
        assertEquals(OrderLineMapper.class, new OrderLineMapper().getClass());
    }

    @Test
    void mapsOrderLineAndDoesNotMapOrderBackReference() {
        OrderLineDTO dto = new OrderLineDTO(
                ID,
                "tx_id",
                ID,
                ID,
                2,
                new BigDecimal("12.50"),
                NOW,
                NOW);

        OrderLineEntity entity = OrderLineMapper.toEntity(dto);

        assertEquals(dto, OrderLineMapper.toDto(entity));
        assertEquals(ID, entity.getProductId());
        assertEquals(ID, entity.getOrderId());
    }

    @Test
    void returnsNullForNullOrderLine() {
        assertNull(OrderLineMapper.toEntity(null));
        assertNull(OrderLineMapper.toDto(null));
    }
}
