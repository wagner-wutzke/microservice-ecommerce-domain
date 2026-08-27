package net.wowdev.ecommerce.domain.events;

import java.math.BigDecimal;
import java.util.UUID;


public record ItemRemovedFromOrderEvent(
        UUID eventId,
        UUID orderId,
        BigDecimal quantity,
        BigDecimal price) { }
