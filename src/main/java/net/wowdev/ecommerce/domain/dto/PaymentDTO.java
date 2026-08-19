package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.entity.PaymentMethod;
import net.wowdev.ecommerce.domain.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
