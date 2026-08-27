package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.ShippingDTO;
import net.wowdev.ecommerce.domain.entity.ShippingEntity;
import net.wowdev.ecommerce.domain.enums.DeliveryStatus;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ShippingMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsShippingBothWays() {
        ShippingDTO dto = new ShippingDTO(
                ID, ID, ID, ID, DeliveryStatus.IN_TRANSIT, "TRACK-1", "Carrier", "https://carrier/track-1", NOW, NOW);

        ShippingEntity entity = ShippingMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getShippingStatus(), entity.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), entity.getTrackingNumber());
        assertEquals(dto.getCarrier(), entity.getCarrier());
        assertEquals(dto.getTrackingUrl(), entity.getTrackingUrl());
        assertEquals(ID, entity.getOrderId());
        assertEquals(ID, entity.getCustomerId());
        assertEquals(ID, entity.getShippingAddressId());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());

        ShippingDTO mappedDto = ShippingMapper.toDto(entity);

        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getShippingStatus(), mappedDto.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), mappedDto.getTrackingNumber());
        assertEquals(dto.getCarrier(), mappedDto.getCarrier());
        assertEquals(dto.getTrackingUrl(), mappedDto.getTrackingUrl());
        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getOrderId(), mappedDto.getOrderId());
        assertEquals(dto.getCustomerId(), mappedDto.getCustomerId());
        assertEquals(dto.getShippingAddressId(), mappedDto.getShippingAddressId());
        assertEquals(dto.getShippingStatus(), mappedDto.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), mappedDto.getTrackingNumber());
        assertEquals(dto.getCarrier(), mappedDto.getCarrier());
        assertEquals(dto.getTrackingUrl(), mappedDto.getTrackingUrl());
        assertNull(mappedDto.getCreatedAt());
        assertNull(mappedDto.getModifiedAt());
    }

    @Test
    void returnsNullForNullShipping() {
        assertNull(ShippingMapper.toEntity(null));
        assertNull(ShippingMapper.toDto(null));
    }
}
