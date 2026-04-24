package com.educandoweb.course.repository;

import com.educandoweb.course.model.OrderItem;
import com.educandoweb.course.model.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
