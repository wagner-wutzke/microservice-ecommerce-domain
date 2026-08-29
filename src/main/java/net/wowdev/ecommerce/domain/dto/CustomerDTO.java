package net.wowdev.ecommerce.domain.dto;

import lombok.*;
import net.wowdev.ecommerce.domain.entity.PaymentMethodEntity;
import net.wowdev.ecommerce.domain.enums.CustomerStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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
    private CustomerStatus customerStatus;
    private List<PaymentMethodDTO> paymentMethods = new ArrayList<>();

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;

    private Instant createdAt;
    private Instant modifiedAt;
}
