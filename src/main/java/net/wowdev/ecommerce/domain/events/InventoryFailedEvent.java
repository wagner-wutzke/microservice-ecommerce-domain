package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

public record InventoryFailedEvent(
        UUID eventId,
        String transactionId,
        UUID orderId,
        UUID productId,
        int quantity,
        String reason,
        Instant createdAt
) {}
