package net.wowdev.ecommerce.domain.events;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.CustomerDTO;

public record CustomerLoadedEvent(
    UUID eventId, String transactionId, CustomerDTO customerDTO, Instant createdAt, String origin) {}
