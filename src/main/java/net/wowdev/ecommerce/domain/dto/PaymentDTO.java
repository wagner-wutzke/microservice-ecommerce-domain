package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.enums.PaymentMethod;
import net.wowdev.ecommerce.domain.enums.PaymentStatus;

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
    private UUID orderId;
    private UUID customerId;
    private String transactionId;
    private String paymentToken;
    private PaymentStatus paymentStatus;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Instant createdAt;
    private Instant modifiedAt;
}
