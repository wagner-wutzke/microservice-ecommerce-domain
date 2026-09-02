package net.wowdev.ecommerce.domain.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.*;
import net.wowdev.ecommerce.domain.enums.PaymentMethod;
import net.wowdev.ecommerce.domain.enums.PaymentStatus;

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
  private UUID paymentMethodId;
  private String paymentToken;
  private String transactionId;
  private PaymentStatus paymentStatus;
  private BigDecimal amount;
  private PaymentMethod paymentMethod;
  private Instant createdAt;
  private Instant modifiedAt;
}
