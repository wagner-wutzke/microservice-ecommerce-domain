package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.PaymentMethodDTO;

public record PaymentMethodReplicationFailed(
    UUID eventId,
    String transactionId,
    PaymentMethodDTO paymentMethodDTO,
    String reason,
    Instant createdAt,
    String origin) {}
