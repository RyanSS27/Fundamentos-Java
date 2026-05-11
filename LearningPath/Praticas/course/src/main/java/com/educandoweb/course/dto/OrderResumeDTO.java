package com.educandoweb.course.dto;

import com.educandoweb.course.model.Order;

import java.time.Instant;

// Utilizada quando quiser chamar o cliente e seus pedidos junto
public class OrderResumeDTO {

    private Long id;
    private Instant moment;

    public OrderResumeDTO() {
    }

    public OrderResumeDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}
