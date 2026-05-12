
package com.educandoweb.course.dto;

import com.educandoweb.course.model.Order;
import com.educandoweb.course.model.OrderItem;
import com.educandoweb.course.model.enums.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static org.apache.el.lang.ELArithmetic.multiply;

@Getter
public class OrderDTO {

    private Long id;
    private Instant moment;

    private Long clientId;
    private String clientName;
    private OrderStatus orderStatus;

    private Set<OrderItemResumeDTO> items = new HashSet<>();

    public OrderDTO() {
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        orderStatus = entity.getOrderStatus();

        if (!entity.getOrderItems().isEmpty())
            for (OrderItem item: entity.getOrderItems())
                items.add(new OrderItemResumeDTO(item));

        clientId = entity.getClient().getId();
        clientName = entity.getClient().getName();
    }

    public BigDecimal getTotal() {
        return this.items.stream()
                .map(item ->
                        item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
