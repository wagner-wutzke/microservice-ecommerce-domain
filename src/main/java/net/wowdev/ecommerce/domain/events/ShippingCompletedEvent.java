package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.ShippingDTO;

public record ShippingCompletedEvent(
    UUID eventId,
    String transactionId,
    ShippingDTO shippingDTO,
    Instant createdAt,
    String origin) {}
