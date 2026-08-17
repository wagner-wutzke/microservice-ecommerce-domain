package net.wowdev.microservice.ecommerce.dto;

import lombok.*;
import net.wowdev.microservice.ecommerce.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private UUID id;
    private CustomerDTO customer;
    private OrderStatus status;
    private AddressDTO shippingAddress;
    private AddressDTO billingAddress;
    private BigDecimal totalAmount;
    private BigDecimal sumAmount;
    private BigDecimal shippingAmount;
    private BigDecimal netAmount;
    private BigDecimal taxAmount;
    private String orderNumber;
    private List<OrderLineDTO> items;
    private Instant createdAt;
    private Instant modifiedAt;
}
