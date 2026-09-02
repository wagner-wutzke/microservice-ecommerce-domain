package net.wowdev.ecommerce.domain.dto;

import java.time.Instant;
import java.util.UUID;
import lombok.*;
import net.wowdev.ecommerce.domain.enums.DeliveryStatus;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShippingDTO {
  private UUID id;
  private UUID orderId;
  private UUID customerId;
  private DeliveryStatus shippingStatus;
  private String trackingNumber;
  private String carrier;
  private String trackingUrl;
  private Instant createdAt;
  private Instant modifiedAt;
}
