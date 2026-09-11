package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.CustomerDTO;
import net.wowdev.ecommerce.domain.dto.OrderDTO;

public record CustomerReplicationCompleted(
    UUID eventId,
    String transactionId,
    CustomerDTO customerDTO,
    Instant createdAt,
    String origin) {}
