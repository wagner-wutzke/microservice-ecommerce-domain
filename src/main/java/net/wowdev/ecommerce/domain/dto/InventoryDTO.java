package net.wowdev.ecommerce.domain.dto;

import java.time.Instant;
import java.util.UUID;
import lombok.*;
import net.wowdev.ecommerce.domain.enums.InventoryChangeType;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryDTO {
  private UUID id;
  private UUID productId;
  private UUID orderId;
  private int currentQuantity;
  private int changedQuantity;
  private int previousQuantity;
  private InventoryChangeType changeType;
  private Instant createdAt;
  private Instant modifiedAt;
}
