package com.educandoweb.course.model;

import com.educandoweb.course.model.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /*
        No paradigma de POO, não existe chave primária composta,
        o identificador do objeto deve ser 1 só.

        Como o par produto e pedido é o que identifica OrderItem,
        eu preciso criar essa classe auxiliar OrderItemPK para
        representar isto.
    */
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EmbeddedId // 'Id integrado'
    private OrderItemPK id = new OrderItemPK();

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

        Temos que fazer, pois para o mundo exterior, é OrderItem
        contém as informações de produto e de pedido
    */
    @JsonIgnore // evitar a chamada cíclica
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
