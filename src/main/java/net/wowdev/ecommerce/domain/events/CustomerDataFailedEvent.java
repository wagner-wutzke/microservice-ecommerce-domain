package net.wowdev.ecommerce.domain.events;

import net.wowdev.ecommerce.domain.dto.CustomerDTO;

import java.time.Instant;
import java.util.UUID;

public record CustomerDataFailedEvent(
        UUID eventId,
        String transactionId,
        CustomerDTO customerDTO,
        String reason,
        Instant createdAt
) {
}
