package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.wowdev.ecommerce.domain.dto.PaymentDTO;


@AllArgsConstructor
@Getter
public class PaymentCreatedEvent extends DomainEvent {
    private PaymentDTO paymentDTO;
}
