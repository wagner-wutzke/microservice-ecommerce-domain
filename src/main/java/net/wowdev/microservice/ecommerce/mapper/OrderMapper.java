package net.wowdev.microservice.ecommerce.mapper;

import java.util.List;
import java.util.Objects;
import net.wowdev.microservice.ecommerce.dto.OrderDTO;
import net.wowdev.microservice.ecommerce.entity.Order;
import net.wowdev.microservice.ecommerce.entity.OrderLine;
import net.wowdev.microservice.ecommerce.entity.OrderStatus;

public final class OrderMapper {
    private OrderMapper() {
    }

    public static Order toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        Order order = new Order(
                dto.getId(),
                OrderStatus.valueOf(dto.getStatus().name()),
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
        List<OrderLine> lines = dto.getItems().stream()
                .filter(Objects::nonNull)
                .map(OrderLineMapper::toEntity)
                .toList();
        lines.forEach(line -> line.setOrder(order));
        order.setItems(new java.util.ArrayList<>(lines));
        return order;
    }

    public static OrderDTO toDto(Order entity) {
        if (entity == null) {
            return null;
        }
        List<net.wowdev.microservice.ecommerce.dto.OrderLineDTO> items = entity.getItems().stream()
                .filter(Objects::nonNull)
                .map(OrderLineMapper::toDto)
                .toList();
        return OrderDTO.newBuilder()
                .setId(entity.getId())
                .setStatus(net.wowdev.microservice.ecommerce.dto.OrderStatus.valueOf(
                        entity.getStatus().name()))
                .setShippingAddress(AddressMapper.toDto(entity.getShippingAddress()))
                .setBillingAddress(AddressMapper.toDto(entity.getBillingAddress()))
                .setTotalAmount(entity.getTotalAmount())
                .setSumAmount(entity.getSumAmount())
                .setShippingAmount(entity.getShippingAmount())
                .setNetAmount(entity.getNetAmount())
                .setTaxAmount(entity.getTaxAmount())
                .setOrderNumber(entity.getOrderNumber())
                .setItems(items)
                .setCreatedAt(entity.getCreatedAt())
                .setModifiedAt(entity.getModifiedAt())
                .build();
    }
}
