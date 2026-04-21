package com.educandoweb.course.service;

import com.educandoweb.course.repository.CategoryRepository;
import com.educandoweb.course.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> objeto = categoryRepository.findById(id);
        return objeto.get();
    }
}
