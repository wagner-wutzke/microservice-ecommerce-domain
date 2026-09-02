package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.ShippingDTO;

public record ShippingFailedEvent(
    UUID eventId,
    String transactionId,
    ShippingDTO shippingDTO,
    String reason,
    Instant createdAt,
    String origin) {}
