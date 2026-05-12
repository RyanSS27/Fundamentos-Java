package com.educandoweb.course.service;

import com.educandoweb.course.dto.OrderDTO;
import com.educandoweb.course.model.Order;
import com.educandoweb.course.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Set<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        if (!orders.isEmpty()) {
            Set<OrderDTO> orderDTOList = new HashSet<>();
            for (Order order : orders)
                orderDTOList.add(new OrderDTO(order));

            return orderDTOList;
        }

        return null;
    }

    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));
        return new OrderDTO(order);

        // verificar por que não funciona fazer um: OrderDTO order = new OrderDTO(findById(id))
    }
}
