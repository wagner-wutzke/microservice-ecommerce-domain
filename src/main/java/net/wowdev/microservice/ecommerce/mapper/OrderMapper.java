package net.wowdev.microservice.ecommerce.mapper;

import net.wowdev.microservice.ecommerce.dto.OrderDTO;
import net.wowdev.microservice.ecommerce.dto.OrderLineDTO;
import net.wowdev.microservice.ecommerce.entity.OrderEntity;
import net.wowdev.microservice.ecommerce.entity.OrderLineEntity;

import java.util.List;
import java.util.Objects;

public final class OrderMapper {

    public static OrderEntity toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity(
                dto.getId(),
                CustomerMapper.toEntity(dto.getCustomer()),
                dto.getStatus(),
                AddressMapper.toEntity(dto.getShippingAddress()),
                AddressMapper.toEntity(dto.getBillingAddress()),
                dto.getTotalAmount(),
                dto.getSumAmount(),
                dto.getShippingAmount(),
                dto.getNetAmount(),
                dto.getTaxAmount(),
                dto.getOrderNumber(),
                new java.util.ArrayList<>(),
                dto.getCreatedAt(),
                dto.getModifiedAt());
        List<OrderLineEntity> lines = dto.getItems().stream()
                .filter(Objects::nonNull)
                .map(OrderLineMapper::toEntity)
                .toList();
        lines.forEach(line -> line.setOrder(orderEntity));
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
                CustomerMapper.toDto(entity.getCustomer()),
                entity.getStatus(),
                AddressMapper.toDto(entity.getShippingAddressEntity()),
                AddressMapper.toDto(entity.getBillingAddressEntity()),
                entity.getTotalAmount(),
                entity.getSumAmount(),
                entity.getShippingAmount(),
                entity.getNetAmount(),
                entity.getTaxAmount(),
                entity.getOrderNumber(),
                items,
                entity.getCreatedAt(),
                entity.getModifiedAt());
    }
}
