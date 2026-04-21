package com.educandoweb.course.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_product_category")
public class Category implements Serializable {
    private static final Long serialVersionID = 1L;

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;
    
// >>AINDA NÃO REALIZADA A ASSOCIAÇÃO ENTRE AS CLASSES<<
//    @Transient
//    @Setter(AccessLevel.NONE)
//    @ManyToMany
//    @JoinColumn(name = "product_id")
//    private Set<Product> products = new HashSet<>();

    public Category() {}

    public Category(Long id, String name) {
        this. id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
