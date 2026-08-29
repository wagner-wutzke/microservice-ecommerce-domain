package net.wowdev.ecommerce.domain.events;

import net.wowdev.ecommerce.domain.dto.CustomerDTO;

import java.time.Instant;
import java.util.UUID;

public record PaymentMethodLoadedEvent(
        UUID eventId,
        String transactionId,
        CustomerDTO customerDTO,
        Instant createdAt
) {
}
