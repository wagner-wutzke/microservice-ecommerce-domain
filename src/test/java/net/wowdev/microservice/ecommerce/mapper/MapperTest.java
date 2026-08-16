package net.wowdev.microservice.ecommerce.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import net.wowdev.microservice.ecommerce.dto.AddressDTO;
import net.wowdev.microservice.ecommerce.dto.CustomerDTO;
import net.wowdev.microservice.ecommerce.dto.CustomerStatus;
import net.wowdev.microservice.ecommerce.dto.InventoryChangeType;
import net.wowdev.microservice.ecommerce.dto.InventoryDTO;
import net.wowdev.microservice.ecommerce.dto.OrderDTO;
import net.wowdev.microservice.ecommerce.dto.OrderLineDTO;
import net.wowdev.microservice.ecommerce.dto.OrderStatus;
import net.wowdev.microservice.ecommerce.dto.PaymentDTO;
import net.wowdev.microservice.ecommerce.dto.PaymentMethod;
import net.wowdev.microservice.ecommerce.dto.PaymentStatus;
import net.wowdev.microservice.ecommerce.dto.ProductDTO;
import net.wowdev.microservice.ecommerce.entity.Address;
import net.wowdev.microservice.ecommerce.entity.Customer;
import net.wowdev.microservice.ecommerce.entity.Inventory;
import net.wowdev.microservice.ecommerce.entity.Order;
import net.wowdev.microservice.ecommerce.entity.OrderLine;
import net.wowdev.microservice.ecommerce.entity.Product;
import net.wowdev.microservice.ecommerce.entity.Payment;
import org.junit.jupiter.api.Test;

class MapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsAddressAndProductBothWays() {
        AddressDTO addressDto = AddressDTO.newBuilder()
                .setId(ID)
                .setAddressLine1("One")
                .setAddressLine2("Two")
                .setCity("City")
                .setStateProvince("State")
                .setPostalCode("123")
                .setCountry("BR")
                .setCreatedAt(NOW)
                .setModifiedAt(NOW)
                .build();
        Address address = AddressMapper.toEntity(addressDto);
        assertEquals(addressDto, AddressMapper.toDto(address));

        ProductDTO productDto = ProductDTO.newBuilder()
                .setId(ID)
                .setName("Book")
                .setDescription("A book")
                .setUnitPrice(12.5)
                .setCurrency("BRL")
                .setCategory("Books")
                .setCreatedAt(NOW)
                .setModifiedAt(NOW)
                .build();
        Product product = ProductMapper.toEntity(productDto);
        assertEquals(productDto, ProductMapper.toDto(product));
        assertNull(AddressMapper.toEntity(null));
        assertNull(AddressMapper.toDto(null));
        assertNull(ProductMapper.toEntity(null));
        assertNull(ProductMapper.toDto(null));
    }

    @Test
    void mapsCustomerBothWays() {
        Address address = new Address(ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW);
        Customer customer = new Customer(
                ID,
                "Ada",
                "Lovelace",
                "ada@example.com",
                LocalDate.of(1815, 12, 10),
                net.wowdev.microservice.ecommerce.entity.CustomerStatus.ACTIVE,
                address,
                address,
                NOW,
                NOW);
        CustomerDTO dto = CustomerMapper.toDto(customer);
        Customer mapped = CustomerMapper.toEntity(dto);
        assertEquals(customer.getEmail(), mapped.getEmail());
        assertEquals(CustomerStatus.ACTIVE, dto.getStatus());
        assertEquals(customer.getBillingAddress().getCity(), mapped.getBillingAddress().getCity());
        assertNull(CustomerMapper.toEntity(null));
        assertNull(CustomerMapper.toDto(null));
    }

    @Test
    void mapsOrderAndLinesBothWays() {
        Product product = new Product(ID, "Book", "A book", 12.5, "BRL", "Books", NOW, NOW);
        Address address = new Address(ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW);
        OrderLine line = new OrderLine(
                ID,
                product,
                null,
                2,
                new BigDecimal("12.50"),
                new BigDecimal("25.00"),
                NOW,
                NOW);
        Order order = new Order(
                ID,
                net.wowdev.microservice.ecommerce.entity.OrderStatus.CONFIRMED,
                address,
                address,
                new BigDecimal("25.00"),
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                "ORD-1",
                List.of(line),
                NOW,
                NOW);
        line.setOrder(order);
        OrderDTO dto = OrderMapper.toDto(order);
        Order mapped = OrderMapper.toEntity(dto);
        assertEquals(order.getOrderNumber(), mapped.getOrderNumber());
        assertEquals(OrderStatus.CONFIRMED, dto.getStatus());
        assertEquals(1, mapped.getItems().size());
        assertEquals(order.getItems().getFirst().getPrice(), mapped.getItems().getFirst().getPrice());
        assertEquals(mapped, mapped.getItems().getFirst().getOrder());
        assertNull(OrderMapper.toEntity(null));
        assertNull(OrderMapper.toDto(null));
        assertNull(OrderLineMapper.toEntity(null));
        assertNull(OrderLineMapper.toDto(null));
    }

    @Test
    void mapsInventoryAndPaymentBothWays() {
        Product product = new Product(ID, "Book", "A book", 12.5, "BRL", "Books", NOW, NOW);
        Address address = new Address(ID, "One", "Two", "City", "State", "123", "BR", NOW, NOW);
        Order order = new Order(
                ID,
                net.wowdev.microservice.ecommerce.entity.OrderStatus.CONFIRMED,
                address,
                address,
                new BigDecimal("25.00"),
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                new BigDecimal("25.00"),
                BigDecimal.ZERO,
                "ORD-1",
                List.of(),
                NOW,
                NOW);
        Inventory inventory = new Inventory(
                ID,
                product,
                order,
                10,
                2,
                net.wowdev.microservice.ecommerce.entity.InventoryChangeType.INVENTORY_INCREASE,
                NOW,
                NOW);
        InventoryDTO inventoryDto = InventoryMapper.toDto(inventory);
        Inventory mappedInventory = InventoryMapper.toEntity(inventoryDto);
        assertEquals(inventory.getQuantity(), mappedInventory.getQuantity());
        assertEquals(InventoryChangeType.INVENTORY_INCREASE, inventoryDto.getChangeType());

        Payment payment = new Payment(
                ID,
                "tx-1",
                new BigDecimal("25.00"),
                "BRL",
                net.wowdev.microservice.ecommerce.entity.PaymentMethod.PIX,
                net.wowdev.microservice.ecommerce.entity.PaymentStatus.COMPLETED,
                NOW,
                NOW);
        PaymentDTO paymentDto = PaymentMapper.toDto(payment);
        Payment mappedPayment = PaymentMapper.toEntity(paymentDto);
        assertEquals(payment.getAmount(), mappedPayment.getAmount());
        assertEquals(PaymentMethod.PIX, paymentDto.getPaymentMethod());
        assertEquals(PaymentStatus.COMPLETED, paymentDto.getStatus());
        assertNull(InventoryMapper.toEntity(null));
        assertNull(InventoryMapper.toDto(null));
        assertNull(PaymentMapper.toEntity(null));
        assertNull(PaymentMapper.toDto(null));
    }
}
