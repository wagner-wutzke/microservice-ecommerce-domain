package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private UUID id;
    private UUID customerId;
    private OrderStatus status;
    private UUID shippingAddressId;
    private UUID billingAddressId;
    private BigDecimal totalAmount;
    private BigDecimal shippingAmount;
    private BigDecimal taxAmount;
    private BigDecimal discountAmount;
    private BigDecimal orderAmount;
    private String orderNumber;
    private List<OrderLineDTO> items;
    private Instant createdAt;
    private Instant modifiedAt;
}
