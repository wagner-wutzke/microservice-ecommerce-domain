package net.wowdev.ecommerce.domain.events;

import net.wowdev.ecommerce.domain.dto.PaymentDTO;

import java.time.Instant;
import java.util.UUID;

public record PaymentCompletedEvent(
        UUID eventId,
        String transactionId,
        PaymentDTO paymentDTO,
        Instant createdAt) {
}
