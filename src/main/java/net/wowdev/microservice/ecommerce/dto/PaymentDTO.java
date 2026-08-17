package net.wowdev.microservice.ecommerce.dto;

import lombok.*;
import net.wowdev.microservice.ecommerce.entity.PaymentMethod;
import net.wowdev.microservice.ecommerce.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private UUID id;
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private Instant createdAt;
    private Instant modifiedAt;
}
