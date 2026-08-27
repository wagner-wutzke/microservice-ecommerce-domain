package net.wowdev.ecommerce.domain.events;

import net.wowdev.ecommerce.domain.dto.OrderDTO;

import java.time.Instant;
import java.util.UUID;

public record OrderCompletedEvent(
        UUID eventId,
        OrderDTO orderDTO,
        Instant createdAt
) {
}
