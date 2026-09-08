package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.OrderDTO;
import net.wowdev.ecommerce.domain.dto.ShipmentDTO;

public record ShipmentCompletedEvent(
    UUID eventId,
    String transactionId,
    OrderDTO orderDTO,
    ShipmentDTO shipmentDTO,
    Instant createdAt,
    String origin) {}
