package com.educandoweb.course.dto;

import com.educandoweb.course.model.Order;
import com.educandoweb.course.model.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

// DTO precisa conter os dados que irão entrar/sair da API de cada entidade
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<OrderResumeDTO> orders = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        phone = user.getPhone();

        for (Order order: user.getOrders()) {
            orders.add(new OrderResumeDTO(order));
        }
    }


    // não entra por ser sensível: private String password;
}
