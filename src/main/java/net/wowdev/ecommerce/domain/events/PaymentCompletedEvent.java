package net.wowdev.ecommerce.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.wowdev.ecommerce.domain.dto.PaymentDTO;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PaymentCompletedEvent extends DomainEvent {
    private PaymentDTO paymentDTO;
}
