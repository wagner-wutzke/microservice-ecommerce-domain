package net.wowdev.ecommerce.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderLineDTO {
    private UUID id;
    private UUID orderId;
    private UUID productId;
    private int quantity;
    private BigDecimal price;
    private Instant createdAt;
    private Instant modifiedAt;
}
