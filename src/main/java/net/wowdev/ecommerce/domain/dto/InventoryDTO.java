package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.enums.InventoryChangeType;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryDTO {
    private UUID id;
    private ProductDTO product;
    private OrderDTO order;
    private int quantity;
    private int changedQuantity;
    private InventoryChangeType changeType;
    private Instant createdAt;
    private Instant modifiedAt;
}
