package com.educandoweb.course.service;

import com.educandoweb.course.model.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra a classe como um componente do Spring de Serviço
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> objeto = userRepository.findById(id);
        return objeto.get(); // retorna o usuário dentro de "objeto"
    }
}
