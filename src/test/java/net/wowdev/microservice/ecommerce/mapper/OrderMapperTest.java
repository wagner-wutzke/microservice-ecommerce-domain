package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.AddressDTO;
import net.wowdev.microservice.ecommerce.dto.OrderDTO;
import net.wowdev.microservice.ecommerce.dto.OrderLineDTO;
import net.wowdev.microservice.ecommerce.dto.ProductDTO;
import net.wowdev.microservice.ecommerce.entity.AddressEntity;
import net.wowdev.microservice.ecommerce.entity.OrderEntity;
import net.wowdev.microservice.ecommerce.entity.OrderLineEntity;
import net.wowdev.microservice.ecommerce.entity.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");
    private static final AddressDTO ADDRESS = new AddressDTO(
            ID,
            "One",
            "Two",
            "City",
            "State",
            "123",
            "BR",
            NOW,
            NOW);
    private static final ProductDTO PRODUCT = new ProductDTO(
            ID,
            "Book",
            "A book",
            12.5,
            "BRL",
            "Books",
            NOW,
            NOW);

    @Test
    void mapsOrderAndLinesBothWaysAndRestoresBackReference() {
        OrderLineDTO line = new OrderLineDTO(
                ID,
                PRODUCT,
                null,
                2,
                new BigDecimal("12.50"),
                new BigDecimal("25.00"),
                NOW,
                NOW);
        OrderDTO dto = new OrderDTO(
                ID,
                null,
                OrderStatus.CONFIRMED,
                ADDRESS,
                ADDRESS,
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
        assertSame(entity, entity.getOrderLines().getFirst().getOrder());
        OrderDTO mappedDto = OrderMapper.toDto(entity);
        assertEquals(dto.getOrderNumber(), mappedDto.getOrderNumber());
        assertEquals(List.of(line), mappedDto.getItems());
    }

    @Test
    void mapsOrderWithNullLinesInEntity() {
        OrderEntity entity = new OrderEntity(
                ID,
                null,
                OrderStatus.CONFIRMED,
                new AddressEntity(ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW),
                new AddressEntity(ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW),
                new BigDecimal("25.00"),
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                "ORD-2",
                Collections.singletonList((OrderLineEntity) null),
                NOW,
                NOW);

        assertEquals(List.of(), OrderMapper.toDto(entity).getItems());
    }

    @Test
    void returnsNullForNullOrder() {
        assertNull(OrderMapper.toEntity(null));
        assertNull(OrderMapper.toDto(null));
    }
}
