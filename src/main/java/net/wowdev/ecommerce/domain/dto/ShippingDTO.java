package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.enums.DeliveryStatus;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShippingDTO {
    private UUID id;
    private String transactionId;
    private UUID orderId;
    private UUID customerId;
    private DeliveryStatus shippingStatus;
    private String trackingNumber;
    private String carrier;
    private String trackingUrl;
    private Instant createdAt;
    private Instant modifiedAt;
}
