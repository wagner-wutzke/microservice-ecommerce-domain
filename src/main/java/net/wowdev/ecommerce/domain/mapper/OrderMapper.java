package net.wowdev.ecommerce.domain.mapper;

import net.wowdev.ecommerce.domain.dto.OrderDTO;
import net.wowdev.ecommerce.domain.dto.OrderLineDTO;
import net.wowdev.ecommerce.domain.entity.OrderEntity;
import net.wowdev.ecommerce.domain.entity.OrderLineEntity;

import java.util.List;
import java.util.Objects;

public final class OrderMapper {

    public static OrderEntity toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity(
                dto.getId(),
                dto.getCustomerId(),
                dto.getStatus(),
                dto.getShippingAddressId(),
                dto.getBillingAddressId(),
                dto.getTotalAmount(),
                dto.getShippingAmount(),
                dto.getTaxAmount(),
                dto.getDiscountAmount(),
                dto.getOrderAmount(),
                dto.getOrderNumber(),
                new java.util.ArrayList<>(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
        List<OrderLineEntity> lines = dto.getItems().stream()
                .filter(Objects::nonNull)
                .map(OrderLineMapper::toEntity)
                .toList();
        lines.forEach(line -> line.setOrderId(orderEntity.getId()));
        orderEntity.setOrderLines(new java.util.ArrayList<>(lines));
        return orderEntity;
    }

    public static OrderDTO toDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }
        List<OrderLineDTO> items = entity.getOrderLines().stream()
                .filter(Objects::nonNull)
                .map(OrderLineMapper::toDto)
                .toList();
        return new OrderDTO(
                entity.getId(),
                entity.getCustomerId(),
                entity.getStatus(),
                entity.getShippingAddressId(),
                entity.getBillingAddressId(),
                entity.getTotalAmount(),
                entity.getShippingAmount(),
                entity.getTaxAmount(),
                entity.getDiscountAmount(),
                entity.getOrderAmount(),
                entity.getOrderNumber(),
                items,
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
