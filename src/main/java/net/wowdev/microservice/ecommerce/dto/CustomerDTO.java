package net.wowdev.microservice.ecommerce.dto;

import lombok.*;
import net.wowdev.microservice.ecommerce.entity.CustomerStatus;

import java.time.Instant;
import java.time.LocalDate;
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
    private LocalDate dateOfBirth;
    private CustomerStatus status;
    private AddressDTO billingAddress;
    private AddressDTO shippingAddress;
    private Instant createdAt;
    private Instant modifiedAt;
}
