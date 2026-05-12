package com.educandoweb.course.dto;

import com.educandoweb.course.model.OrderItem;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderItemResumeDTO {
    private BigDecimal price;
    private int quantity;

    public OrderItemResumeDTO() {
    }

    public OrderItemResumeDTO(BigDecimal price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemResumeDTO(OrderItem item) {
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
    }
}
