package net.wowdev.ecommerce.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.InventoryDTO;
import net.wowdev.ecommerce.domain.entity.InventoryEntity;
import net.wowdev.ecommerce.domain.enums.InventoryChangeType;
import org.junit.jupiter.api.Test;

class InventoryMapperTest {
  private static final UUID ID = UUID.randomUUID();
  private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

  @Test
  void mapsInventoryBothWays() {
    InventoryDTO dto =
        new InventoryDTO(ID, ID, ID, 10, 2, 8, InventoryChangeType.INVENTORY_INCREASE, NOW, NOW);

    InventoryEntity entity = InventoryMapper.toEntity(dto);

    assertEquals(10, entity.getCurrentQuantity());
    assertEquals(2, entity.getChangedQuantity());
    assertEquals(8, entity.getPreviousQuantity());
    assertEquals(
        InventoryChangeType.INVENTORY_INCREASE, InventoryMapper.toDto(entity).getChangeType());
    InventoryDTO mappedDto = InventoryMapper.toDto(entity);
    assertEquals(dto.getId(), mappedDto.getId());
    assertEquals(dto.getProductId(), mappedDto.getProductId());
    assertEquals(dto.getOrderId(), mappedDto.getOrderId());
    assertEquals(dto.getCurrentQuantity(), mappedDto.getCurrentQuantity());
    assertEquals(dto.getChangedQuantity(), mappedDto.getChangedQuantity());
    assertEquals(dto.getPreviousQuantity(), mappedDto.getPreviousQuantity());
    assertEquals(dto.getCreatedAt(), mappedDto.getCreatedAt());
    assertNull(mappedDto.getModifiedAt());
    assertNull(entity.getModifiedAt());
  }

  @Test
  void returnsNullForNullInventory() {
    assertNull(InventoryMapper.toEntity(null));
    assertNull(InventoryMapper.toDto(null));
  }
}
