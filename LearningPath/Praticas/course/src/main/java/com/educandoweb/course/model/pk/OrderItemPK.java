package com.educandoweb.course.model.pk;

import com.educandoweb.course.model.Order;
import com.educandoweb.course.model.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
/*
    Por ser uma classe auxiliar de primary key composta
*/
@Embeddable //
public class OrderItemPK implements Serializable {
    private static final long serialVersionID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Override
    public boolean equals(Object o) {
        // Precisa comparar os 2 atributos pela classe não ter uma chave primária própria,
        // pois é identificada por seus 2 itens
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
