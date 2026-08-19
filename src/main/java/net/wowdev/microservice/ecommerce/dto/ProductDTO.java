package net.wowdev.microservice.ecommerce.dto;

import lombok.*;

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
    private double unitPrice;
    private String currency;
    private String category;
    private Instant createdAt;
    private Instant modifiedAt;
}
