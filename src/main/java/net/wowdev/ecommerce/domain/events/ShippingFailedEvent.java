package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.wowdev.ecommerce.domain.dto.ShippingDTO;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ShippingFailedEvent extends DomainEvent {
    private ShippingDTO shippingDTO;
    private String reason;
}
