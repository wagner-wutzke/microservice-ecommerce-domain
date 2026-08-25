package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.wowdev.ecommerce.domain.dto.OrderDTO;

@AllArgsConstructor
@Getter
public final class OrderCreatedEvent extends DomainEvent {
    private OrderDTO order;
}
