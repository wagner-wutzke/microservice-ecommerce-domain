package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderDTO;
import net.wowdev.ecommerce.domain.dto.ShippingDTO;
import net.wowdev.ecommerce.domain.entity.ShippingEntity;
import net.wowdev.ecommerce.domain.enums.DeliveryStatus;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ShippingMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsShippingBothWays() {
        OrderDTO order = new OrderDTO(null, null, null, null, null, null, null, null, null,
                null, null, List.of(), NOW, NOW);
        ShippingDTO dto = new ShippingDTO(
                ID, order, DeliveryStatus.IN_TRANSIT, "TRACK-1", "Carrier", "https://carrier/track-1", NOW, NOW);

        ShippingEntity entity = ShippingMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getShippingStatus(), entity.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), entity.getTrackingNumber());
        assertEquals(dto.getCarrier(), entity.getCarrier());
        assertEquals(dto.getTrackingUrl(), entity.getTrackingUrl());
        assertEquals(0, entity.getOrderEntity().getOrderLines().size());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());

        ShippingDTO mappedDto = ShippingMapper.toDto(entity);

        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getShippingStatus(), mappedDto.getShippingStatus());
        assertEquals(dto.getTrackingNumber(), mappedDto.getTrackingNumber());
        assertEquals(dto.getCarrier(), mappedDto.getCarrier());
        assertEquals(dto.getTrackingUrl(), mappedDto.getTrackingUrl());
        assertEquals(dto.getOrder().getItems(), mappedDto.getOrder().getItems());
    }

    @Test
    void returnsNullForNullShipping() {
        assertNull(ShippingMapper.toEntity(null));
        assertNull(ShippingMapper.toDto(null));
    }
}
