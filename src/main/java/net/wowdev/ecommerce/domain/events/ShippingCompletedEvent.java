package net.wowdev.ecommerce.domain.events;

import net.wowdev.ecommerce.domain.dto.ShippingDTO;

import java.time.Instant;
import java.util.UUID;


public record ShippingCompletedEvent(
    UUID eventId,
    String transactionId,
    ShippingDTO shippingDTO,
    Instant createdAt
) {}
