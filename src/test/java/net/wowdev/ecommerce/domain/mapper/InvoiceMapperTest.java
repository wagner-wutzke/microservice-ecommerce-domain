package net.wowdev.ecommerce.domain.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.UUID;
import net.wowdev.ecommerce.domain.dto.InvoiceDTO;
import net.wowdev.ecommerce.domain.entity.InvoiceEntity;
import org.junit.jupiter.api.Test;

class InvoiceMapperTest {
    private static final UUID ID = UUID.randomUUID();
    private static final UUID TRANSACTION_ID = UUID.randomUUID();
    private static final UUID ORDER_ID = UUID.randomUUID();
    private static final UUID CUSTOMER_ID = UUID.randomUUID();
    private static final Instant NOW = Instant.parse("2026-01-01T00:00:00Z");

    @Test
    void mapsInvoiceBothWays() {
        InvoiceDTO dto = new InvoiceDTO(
                ID,
                ORDER_ID,
                CUSTOMER_ID,
                "INV-2026-0001",
                true,
                "https://example.test/invoices/INV-2026-0001.pdf",
                "invoice-0001.pdf",
                NOW,
                NOW);

        InvoiceEntity entity = InvoiceMapper.toEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getOrderId(), entity.getOrderId());
        assertEquals(dto.getCustomerId(), entity.getCustomerId());
        assertEquals(dto.getInvoiceNumber(), entity.getInvoiceNumber());
        assertEquals(dto.isDelivered(), entity.isDelivered());
        assertEquals(dto.getDocumentUrl(), entity.getDocumentUrl());
        assertEquals(dto.getDocumentName(), entity.getDocumentName());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getModifiedAt());

        InvoiceDTO mappedDto = InvoiceMapper.toDto(entity);

        assertEquals(dto.getId(), mappedDto.getId());
        assertEquals(dto.getOrderId(), mappedDto.getOrderId());
        assertEquals(dto.getCustomerId(), mappedDto.getCustomerId());
        assertEquals(dto.getInvoiceNumber(), mappedDto.getInvoiceNumber());
        assertEquals(dto.isDelivered(), mappedDto.isDelivered());
        assertEquals(dto.getDocumentUrl(), mappedDto.getDocumentUrl());
        assertEquals(dto.getDocumentName(), mappedDto.getDocumentName());
        assertNull(mappedDto.getCreatedAt());
        assertNull(mappedDto.getModifiedAt());
    }

    @Test
    void mapsUndeliveredInvoice() {
        InvoiceEntity entity = new InvoiceEntity(
                ID, ORDER_ID, CUSTOMER_ID, "INV-2026-0002", false,
                null, null, NOW, NOW);

        InvoiceDTO dto = InvoiceMapper.toDto(entity);

        assertFalse(dto.isDelivered());
        assertEquals(NOW, dto.getCreatedAt());
        assertEquals(NOW, dto.getModifiedAt());
    }

    @Test
    void returnsNullForNullInvoice() {
        assertNull(InvoiceMapper.toEntity(null));
        assertNull(InvoiceMapper.toDto(null));
    }
}
