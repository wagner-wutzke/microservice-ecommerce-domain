package net.wowdev.ecommerce.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.CustomerDTO;
import net.wowdev.ecommerce.domain.entity.CustomerEntity;
import net.wowdev.ecommerce.domain.enums.CustomerStatus;
import org.junit.jupiter.api.Test;

class CustomerMapperTest {
  private static final UUID ID = UUID.randomUUID();
  private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

  @Test
  void mapsCustomerBothWays() {
    CustomerDTO dto =
        new CustomerDTO(
            ID,
            "Ada",
            "Lovelace",
            "ada@example.com",
            CustomerStatus.ACTIVE,
            List.of(),
            "1 Main Street",
            "Apt 2",
            "City",
            "State",
            "11111-111",
            "BR",
            NOW,
            NOW);

    CustomerEntity entity = CustomerMapper.toEntity(dto);

    assertEquals(dto, CustomerMapper.toDto(entity));
    assertEquals(dto.getAddressLine1(), entity.getAddressLine1());
    assertEquals(dto.getAddressLine2(), entity.getAddressLine2());
    assertEquals(dto.getCountry(), entity.getCountry());
  }

  @Test
  void returnsNullForNullCustomer() {
    assertNull(CustomerMapper.toEntity(null));
    assertNull(CustomerMapper.toDto(null));
  }
}
