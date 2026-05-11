
package com.educandoweb.course.dto;

import com.educandoweb.course.model.Order;

import java.time.Instant;

public class OrderDTO {

    private Long id;
    private Instant moment;

    private Long clientId;
    private String clientName;

    public OrderDTO() {
    }

    public OrderDTO(Order entity) {

        id = entity.getId();
        moment = entity.getMoment();

        clientId = entity.getClient().getId();
        clientName = entity.getClient().getName();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }
}
