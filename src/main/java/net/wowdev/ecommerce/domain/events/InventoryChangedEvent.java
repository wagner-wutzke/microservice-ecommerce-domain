package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class InventoryChangedEvent extends DomainEvent {
    private UUID productId;
    private int quantity;
}
