package com.educandoweb.course.model;

import com.educandoweb.course.model.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionID = 1L;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EmbeddedId
    private OrderItemPK id;

    private Integer quantity;

    private BigDecimal price;


    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, BigDecimal price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    /*
        GETTERS E SETTERS DO PRODUCT E ORDER

        Temos que fazer, pois para o mundo exterior, OrderItem
        contém as informações de produto e de pedido
    */
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
