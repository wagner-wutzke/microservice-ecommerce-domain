package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.CustomerDTO;

public record CustomerReplicationFailed(
    UUID eventId,
    String transactionId,
    CustomerDTO customerDTO,
    String reason,
    Instant createdAt,
    String origin) {}
