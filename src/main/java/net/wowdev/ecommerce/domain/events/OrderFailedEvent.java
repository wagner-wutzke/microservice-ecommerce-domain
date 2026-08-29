package net.wowdev.ecommerce.domain.events;


import java.time.Instant;
import java.util.UUID;

public record OrderFailedEvent (
        UUID eventId,
        String transactionId,
        UUID orderId,
        String reason,
        Instant createdAt) {
}
