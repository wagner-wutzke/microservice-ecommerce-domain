package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.AddressDTO;
import net.wowdev.ecommerce.domain.entity.AddressEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AddressMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsAddressBothWays() {
        AddressDTO dto = new AddressDTO(
                ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW);

        AddressEntity entity = AddressMapper.toEntity(dto);

        assertEquals(dto, AddressMapper.toDto(entity));
    }

    @Test
    void returnsNullForNullAddress() {
        assertNull(AddressMapper.toEntity(null));
        assertNull(AddressMapper.toDto(null));
    }
}
