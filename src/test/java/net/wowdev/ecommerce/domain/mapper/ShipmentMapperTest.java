package net.wowdev.ecommerce.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.ShipmentDTO;
import net.wowdev.ecommerce.domain.entity.ShipmentEntity;
import net.wowdev.ecommerce.domain.enums.ShipmentStatus;
import org.junit.jupiter.api.Test;

class ShipmentMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsShippingBothWays() {
        ShipmentDTO dto = new ShipmentDTO(
                ID, ID, ID, ShipmentStatus.IN_TRANSIT, "TRACK-1", "Carrier", "https://carrier/track-1", NOW, NOW);

        ShipmentEntity entity = ShipmentMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getShippingStatus(), entity.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), entity.getTrackingNumber());
        assertEquals(dto.getCarrier(), entity.getCarrier());
        assertEquals(dto.getTrackingUrl(), entity.getTrackingUrl());
        assertEquals(ID, entity.getOrderId());
        assertEquals(ID, entity.getCustomerId());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());

        ShipmentDTO mappedDto = ShipmentMapper.toDto(entity);

        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getShippingStatus(), mappedDto.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), mappedDto.getTrackingNumber());
        assertEquals(dto.getCarrier(), mappedDto.getCarrier());
        assertEquals(dto.getTrackingUrl(), mappedDto.getTrackingUrl());
        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getOrderId(), mappedDto.getOrderId());
        assertEquals(dto.getCustomerId(), mappedDto.getCustomerId());
        assertEquals(dto.getShippingStatus(), mappedDto.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), mappedDto.getTrackingNumber());
        assertEquals(dto.getCarrier(), mappedDto.getCarrier());
        assertEquals(dto.getTrackingUrl(), mappedDto.getTrackingUrl());
        assertNull(mappedDto.getCreatedAt());
        assertNull(mappedDto.getModifiedAt());
    }

    @Test
    void returnsNullForNullShipping() {
        assertNull(ShipmentMapper.toEntity(null));
        assertNull(ShipmentMapper.toDto(null));
    }
}
