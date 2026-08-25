package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.AddressDTO;
import net.wowdev.ecommerce.domain.dto.CustomerDTO;
import net.wowdev.ecommerce.domain.entity.CustomerEntity;
import net.wowdev.ecommerce.domain.enums.CustomerStatus;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");
    private static final AddressDTO ADDRESS = new AddressDTO(
            ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW);

    @Test
    void mapsCustomerBothWaysIncludingAddresses() {
        CustomerDTO dto = new CustomerDTO(
                ID,
                "Ada",
                "Lovelace",
                "ada@example.com",
                LocalDate.of(1815, 12, 10),
                CustomerStatus.ACTIVE,
                ADDRESS,
                ADDRESS,
                NOW,
                NOW);

        CustomerEntity entity = CustomerMapper.toEntity(dto);

        assertEquals(dto, CustomerMapper.toDto(entity));
        assertEquals("City", entity.getBillingAddressEntity().getCity());
    }

    @Test
    void returnsNullForNullCustomer() {
        assertNull(CustomerMapper.toEntity(null));
        assertNull(CustomerMapper.toDto(null));
    }
}
