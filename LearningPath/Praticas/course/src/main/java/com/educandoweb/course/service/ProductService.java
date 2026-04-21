package com.educandoweb.course.service;

import com.educandoweb.course.model.Product;
import com.educandoweb.course.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> objeto = productRepository.findById(id);
        return objeto.get();
    }
}
