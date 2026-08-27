package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ItemAddedToOrderEvent extends DomainEvent {
    private UUID productId;
    private BigDecimal price;
    private int quantity;
}
