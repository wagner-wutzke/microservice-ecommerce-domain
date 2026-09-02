package net.wowdev.ecommerce.domain.dto;

import java.time.Instant;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentMethodDTO {
  private UUID id;
  private UUID customerId;
  // TODO card data must be masked for logs or encoded
  private String cardNumber;
  private String ownerName;
  private String expiration;
  private int cvv;
  private String cardName;
  private Instant createdAt;
  private Instant modifiedAt;
}
