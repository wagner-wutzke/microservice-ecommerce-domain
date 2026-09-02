package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.PaymentMethodDTO;

public record PaymentMethodLoadedEvent(
    UUID eventId,
    String transactionId,
    PaymentMethodDTO paymentMethodDTO,
    Instant createdAt,
    String origin) {}
