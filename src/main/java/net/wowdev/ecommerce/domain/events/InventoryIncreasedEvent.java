package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class InventoryRaisedEvent extends DomainEvent {

    private UUID productId;
    private UUID orderId;
    private int quantity;
}
