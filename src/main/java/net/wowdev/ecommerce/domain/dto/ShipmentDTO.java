package net.wowdev.ecommerce.domain.dto;

import java.time.Instant;
import java.util.UUID;
import lombok.*;
import net.wowdev.ecommerce.domain.enums.ShipmentStatus;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShipmentDTO {
  private UUID id;
  private UUID orderId;
  private UUID customerId;
  private ShipmentStatus shippingStatus;
  private String trackingNumber;
  private String carrier;
  private String trackingUrl;
  private Instant createdAt;
  private Instant modifiedAt;
}
