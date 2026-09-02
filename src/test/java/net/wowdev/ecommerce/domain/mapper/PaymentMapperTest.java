package net.wowdev.ecommerce.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.PaymentDTO;
import net.wowdev.ecommerce.domain.entity.PaymentEntity;
import net.wowdev.ecommerce.domain.enums.PaymentMethod;
import net.wowdev.ecommerce.domain.enums.PaymentStatus;
import org.junit.jupiter.api.Test;

class PaymentMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsPaymentBothWays() {
        PaymentDTO dto = new PaymentDTO(
                ID,
                ID,
                ID,
                ID,
                "token-1",
                "tx-1",
                PaymentStatus.COMPLETED,
                new BigDecimal("25.00"),
                PaymentMethod.PIX,
                NOW,
                NOW);

        PaymentEntity entity = PaymentMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getAmount(), entity.getAmount());
        assertEquals(dto.getOrderId(), entity.getOrderId());
        assertEquals(dto.getTransactionId(), entity.getTransactionId());
        assertEquals(dto.getCustomerId(), entity.getCustomerId());
        assertEquals(dto.getPaymentMethodId(), entity.getPaymentMethodId());
        PaymentDTO mappedDto = PaymentMapper.toDto(entity);
        assertEquals(dto.getPaymentMethod(), mappedDto.getPaymentMethod());
        assertEquals(dto.getPaymentStatus(), mappedDto.getPaymentStatus());
        assertEquals(dto.getTransactionId(), mappedDto.getTransactionId());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());
    }

    @Test
    void returnsNullForNullPayment() {
        assertNull(PaymentMapper.toEntity(null));
        assertNull(PaymentMapper.toDto(null));
    }
}
