package net.wowdev.ecommerce.domain.dto;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
    private UUID id;
    private UUID customerId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;
    private Instant createdAt;
    private Instant modifiedAt;
}
