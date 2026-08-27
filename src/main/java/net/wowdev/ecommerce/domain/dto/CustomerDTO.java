package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.enums.CustomerStatus;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerStatus status;
    private UUID billingAddressId;
    private UUID shippingAddressId;
    private Instant createdAt;
    private Instant modifiedAt;
}
