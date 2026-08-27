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
public class ProductDTO {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String category;
    private Instant createdAt;
    private Instant modifiedAt;
}
