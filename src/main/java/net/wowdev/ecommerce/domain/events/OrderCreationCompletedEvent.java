package net.wowdev.ecommerce.domain.events;

import net.wowdev.ecommerce.domain.dto.OrderDTO;

import java.time.Instant;
import java.util.UUID;

public record OrderCreationCompletedEvent(
        UUID eventId,
        String transactionId,
        OrderDTO orderDTO,
        Instant createdAt
) {}
