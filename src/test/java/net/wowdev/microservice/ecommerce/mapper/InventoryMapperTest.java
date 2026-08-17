package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.InventoryDTO;
import net.wowdev.microservice.ecommerce.dto.OrderDTO;
import net.wowdev.microservice.ecommerce.dto.ProductDTO;
import net.wowdev.microservice.ecommerce.entity.InventoryChangeType;
import net.wowdev.microservice.ecommerce.entity.InventoryEntity;
import net.wowdev.microservice.ecommerce.entity.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InventoryMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsInventoryBothWays() {
        ProductDTO product = new ProductDTO(ID, "Book", "A book", 12.5, "BRL", "Books", NOW, NOW);
        OrderDTO order = new OrderDTO(
                ID,
                null,
                OrderStatus.CONFIRMED,
                null,
                null,
                new BigDecimal("25.00"),
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                "ORD-1",
                List.of(),
                NOW,
                NOW);
        InventoryDTO dto = new InventoryDTO(
                ID, product, order, 10, 2, InventoryChangeType.INVENTORY_INCREASE, NOW, NOW);

        InventoryEntity entity = InventoryMapper.toEntity(dto);

        assertEquals(10, entity.getQuantity());
        assertEquals(InventoryChangeType.INVENTORY_INCREASE, InventoryMapper.toDto(entity).getChangeType());
        assertNull(entity.getModifiedAt());
    }

    @Test
    void returnsNullForNullInventory() {
        assertNull(InventoryMapper.toEntity(null));
        assertNull(InventoryMapper.toDto(null));
    }
}
