package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.OrderDTO;
import net.wowdev.ecommerce.domain.dto.PaymentDTO;

public record PaymentCompletedEvent(
    UUID eventId,
    String transactionId,
    OrderDTO orderDTO,
    PaymentDTO paymentDTO,
    Instant createdAt,
    String origin) {}
