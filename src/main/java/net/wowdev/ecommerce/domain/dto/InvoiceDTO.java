package net.wowdev.ecommerce.domain.dto;

import java.time.Instant;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceDTO {
  private UUID id;
  private UUID orderId;
  private UUID customerId;
  private String invoiceNumber;
  private boolean delivered;
  private String documentUrl;
  private String documentName;
  private Instant createdAt;
  private Instant modifiedAt;
}
