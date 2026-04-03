package com.educandoweb.course.controller;

import com.educandoweb.course.model.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Resource pois é um recurso
@RestController // diz que é um controlador rest
@RequestMapping(value = "/users") // nomeei este recurso de usuário
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping // responde requisições get
    public ResponseEntity<List<User>> retorneTodos() {
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list); // corpo da resposta deve conter as respostas
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> retornePorId(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    // diz que a resposta é do tipo usuário
}
