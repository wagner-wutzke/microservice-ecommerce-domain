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
public class AddressDTO {
    private UUID id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;
    private Instant createdAt;
    private Instant modifiedAt;
}
