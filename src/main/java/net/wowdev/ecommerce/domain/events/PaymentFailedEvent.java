package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.OrderDTO;

public record PaymentFailedEvent(
    UUID eventId,
    String transactionId,
    OrderDTO orderDTO,
    String reason,
    Instant createdAt,
    String origin) {}
