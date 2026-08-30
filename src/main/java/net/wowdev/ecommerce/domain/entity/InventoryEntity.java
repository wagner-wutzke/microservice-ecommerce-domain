package net.wowdev.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import net.wowdev.ecommerce.domain.enums.InventoryChangeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "inventory")
@EntityListeners(AuditingEntityListener.class)
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @JoinColumn(name = "order_id")
    private UUID orderId;

    @Column(name = "current_quantity", nullable = false)
    private int currentQuantity;

    @Column(name = "changed_quantity", nullable = false)
    private int changedQuantity;

    @Column(name = "previous_quantity", nullable = false)
    private int previousQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false)
    private InventoryChangeType changeType;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modifiedAt;
}
