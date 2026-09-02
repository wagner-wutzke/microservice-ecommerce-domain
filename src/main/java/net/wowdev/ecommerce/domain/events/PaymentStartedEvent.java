package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.PaymentDTO;

public record PaymentStartedEvent(
    UUID eventId, String transactionId, PaymentDTO paymentDTO, Instant createdAt, String origin) {}
