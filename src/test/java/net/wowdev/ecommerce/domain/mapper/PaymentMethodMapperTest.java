package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.PaymentMethodDTO;
import net.wowdev.ecommerce.domain.entity.PaymentMethodEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PaymentMethodMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsPaymentMethodBothWays() {
        PaymentMethodDTO dto = new PaymentMethodDTO(
                ID,
                ID,
                "4111111111111111",
                "Ada Lovelace",
                "12/30",
                123,
                "Visa",
                NOW,
                NOW);

        PaymentMethodEntity entity = PaymentMethodMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getCustomerId(), entity.getCustomerId());
        assertEquals(dto.getCardNumber(), entity.getCardNumber());
        assertEquals(dto.getOwnerName(), entity.getOwnerName());
        assertEquals(dto.getExpiration(), entity.getExpiration());
        assertEquals(dto.getCvv(), entity.getCvv());
        assertEquals(dto.getCardName(), entity.getCardName());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());

        PaymentMethodDTO mappedDto = PaymentMethodMapper.toDto(entity);

        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getCustomerId(), mappedDto.getCustomerId());
        assertEquals(dto.getCardNumber(), mappedDto.getCardNumber());
        assertEquals(dto.getOwnerName(), mappedDto.getOwnerName());
        assertEquals(dto.getExpiration(), mappedDto.getExpiration());
        assertEquals(dto.getCvv(), mappedDto.getCvv());
        assertEquals(dto.getCardName(), mappedDto.getCardName());
        assertNull(mappedDto.getCreatedAt());
        assertNull(mappedDto.getModifiedAt());
    }

    @Test
    void mapsPersistedAuditTimestampsToDto() {
        PaymentMethodEntity entity = new PaymentMethodEntity(
                ID, ID, "4111111111111111", "Ada Lovelace", "12/30", 123, "Visa", NOW, NOW);

        PaymentMethodDTO dto = PaymentMethodMapper.toDto(entity);

        assertEquals(NOW, dto.getCreatedAt());
        assertEquals(NOW, dto.getModifiedAt());
    }

    @Test
    void returnsNullForNullPaymentMethod() {
        assertNull(PaymentMethodMapper.toEntity(null));
        assertNull(PaymentMethodMapper.toDto(null));
    }

    @Test
    void canInstantiateMapper() {
        assertEquals(PaymentMethodMapper.class, new PaymentMethodMapper().getClass());
    }
}
