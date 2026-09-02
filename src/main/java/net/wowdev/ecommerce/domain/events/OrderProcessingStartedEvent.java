package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.OrderDTO;

public record OrderProcessingStartedEvent(
    UUID eventId, String transactionId, OrderDTO orderDTO, Instant createdAt, String origin) {}
