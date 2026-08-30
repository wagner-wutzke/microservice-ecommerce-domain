package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderDTO;
import net.wowdev.ecommerce.domain.dto.OrderLineDTO;
import net.wowdev.ecommerce.domain.entity.OrderEntity;
import net.wowdev.ecommerce.domain.enums.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsOrderAndLinesBothWaysAndRestoresBackReference() {
        OrderLineDTO line = new OrderLineDTO(
                ID,
                "tx_id",
                ID,
                ID,
                2,
                new BigDecimal("12.50"),
                NOW,
                NOW);
        OrderDTO dto = new OrderDTO(
                ID,
                "tx_id",
                null,
                ID,
                OrderStatus.CONFIRMED,
                new BigDecimal("25.00"),
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                "ORD-1",
                Arrays.asList(null, line),
                NOW,
                NOW);

        OrderEntity entity = OrderMapper.toEntity(dto);

        assertEquals(1, entity.getOrderLines().size());
        assertEquals(ID, entity.getOrderLines().getFirst().getProductId());
        assertEquals(ID, entity.getOrderLines().getFirst().getOrderId());
        OrderDTO mappedDto = OrderMapper.toDto(entity);
        assertEquals(dto.getOrderNumber(), mappedDto.getOrderNumber());
        assertEquals(List.of(line), mappedDto.getOrderLines());
    }

    @Test
    void mapsOrderWithNullLinesInEntity() {
        OrderEntity entity = new OrderEntity(
                ID,
                "tx_id",
                null,
                ID,
                OrderStatus.CONFIRMED,
                new BigDecimal("25.00"),
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                "ORD-2",
                Collections.singletonList(null),
                NOW,
                NOW);

        assertEquals(List.of(), OrderMapper.toDto(entity).getOrderLines());
    }

    @Test
    void returnsNullForNullOrder() {
        assertNull(OrderMapper.toEntity(null));
        assertNull(OrderMapper.toDto(null));
    }
}
