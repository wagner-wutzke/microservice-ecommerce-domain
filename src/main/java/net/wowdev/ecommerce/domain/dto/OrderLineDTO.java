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
    private ProductDTO product;
    private OrderDTO order;
    private int quantity;
    private BigDecimal price;
    private BigDecimal lineAmount;
    private Instant createdAt;
    private Instant modifiedAt;
}
