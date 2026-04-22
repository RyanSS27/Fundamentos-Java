package com.educandoweb.course.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_products")
public class Product implements Serializable {
    private static final long serialVersionID = 1;

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Long Id;

    @Column(nullable = false)
    private String name;
    private String description;
    private Double price;

    /*
        Set cria conjuntos, onde não há duplicidade de itens.
        Deve-se instanciar um "HashSet", pois "Set" é uma interface
     */
    @ManyToMany
    @JoinTable(
            // Cria uma tabela de associação entre os IDs
            name = "tb_product_category", // nome da tb de associação
            joinColumns = @JoinColumn(name = "product_id"), // nome da column da nova tb
            inverseJoinColumns = @JoinColumn(name = "category_id") // nome da column da nova tb
    )
    private Set<Category> categories = new HashSet<>();

    @Column(name = "img_url", nullable = true)
    private String imgUrl;

    public Product() {}

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(Id, product.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
