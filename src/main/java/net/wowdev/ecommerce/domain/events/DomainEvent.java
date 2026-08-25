package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class DomainEvent {
    private UUID eventId;
    private UUID orderId;
    private Instant createdAt;
}
