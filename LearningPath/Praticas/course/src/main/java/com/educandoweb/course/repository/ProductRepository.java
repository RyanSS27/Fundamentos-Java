package com.educandoweb.course.repository;

import com.educandoweb.course.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
