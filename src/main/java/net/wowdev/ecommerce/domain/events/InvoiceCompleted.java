package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.OrderDTO;

public record InvoiceCompleted(
    UUID eventId,
    String transactionId,
    OrderDTO ordetDTO,
    Instant createdAt,
    String origin) {}
