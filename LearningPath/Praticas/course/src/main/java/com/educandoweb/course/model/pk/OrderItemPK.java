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
    PK: pois é uma classe auxiliar de primary key composta.

    No banco de dados essa é uma tabela de associação que
    carrega atributos extras que não são de Product nem de
    Order.

    Ex: quantidade do item que foi comprada e o preço do
    produto na época em que foi comprado
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
