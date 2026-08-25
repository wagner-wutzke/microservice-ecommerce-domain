package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.wowdev.ecommerce.domain.dto.OrderDTO;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class OrderCancelledEvent {
    private OrderDTO order;
    private String reason;
}
