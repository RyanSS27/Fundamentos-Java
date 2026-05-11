package com.educandoweb.course.service;

import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.model.User;
import com.educandoweb.course.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra a classe como um componente do Spring de Serviço
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        // faça o casting de informações
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    @Transactional
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));;
        return new UserDTO(user); // retorna o usuário dentro de "objeto"
    }
}
