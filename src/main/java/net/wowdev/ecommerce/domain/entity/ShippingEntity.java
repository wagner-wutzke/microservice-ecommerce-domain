package net.wowdev.ecommerce.domain.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.*;
import net.wowdev.ecommerce.domain.enums.DeliveryStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "shippings")
@EntityListeners(AuditingEntityListener.class)
public class ShippingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "order_id", nullable = false)
  private UUID orderId;

  @Column(name = "customer_id", nullable = false)
  private UUID customerId;

  @Enumerated(EnumType.STRING)
  @Column(name = "shipping_status", nullable = false)
  private DeliveryStatus shippingStatus;

  @Column(name = "tracking_number", nullable = false, unique = true)
  private String trackingNumber;

  @Column(name = "carrier", nullable = false)
  private String carrier;

  @Column(name = "tracking_url", nullable = false, length = 2048)
  private String trackingUrl;

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  @LastModifiedDate
  @Column(name = "modified_at")
  private Instant modifiedAt;
}
