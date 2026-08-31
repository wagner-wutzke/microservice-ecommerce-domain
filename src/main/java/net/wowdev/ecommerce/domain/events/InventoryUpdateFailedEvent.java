package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;

public record InventoryUpdateFailedEvent(
        UUID eventId,
        String transactionId,
        UUID orderId,
        UUID productId,
        int quantity,
        String reason,
        Instant createdAt
) {
}
