package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.PaymentDTO;
import net.wowdev.ecommerce.domain.entity.PaymentEntity;
import net.wowdev.ecommerce.domain.enums.PaymentMethod;
import net.wowdev.ecommerce.domain.enums.PaymentStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PaymentMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsPaymentBothWays() {
        PaymentDTO dto = new PaymentDTO(
                ID,
                "tx-1",
                "token-1",
                PaymentStatus.COMPLETED,
                new BigDecimal("25.00"),
                "BRL",
                PaymentMethod.PIX,
                NOW,
                NOW);

        PaymentEntity entity = PaymentMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getAmount(), entity.getAmount());
        PaymentDTO mappedDto = PaymentMapper.toDto(entity);
        assertEquals(dto.getTransactionId(), mappedDto.getTransactionId());
        assertEquals(dto.getPaymentMethod(), mappedDto.getPaymentMethod());
        assertEquals(dto.getPaymentStatus(), mappedDto.getPaymentStatus());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());
    }

    @Test
    void returnsNullForNullPayment() {
        assertNull(PaymentMapper.toEntity(null));
        assertNull(PaymentMapper.toDto(null));
    }
}
