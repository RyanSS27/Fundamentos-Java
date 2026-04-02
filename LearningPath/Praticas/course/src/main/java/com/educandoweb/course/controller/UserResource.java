package com.educandoweb.course.controller;

import com.educandoweb.course.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Resource pois é um recurso
@RestController // diz que é um controlador rest
@RequestMapping(value = "/users") // nomeei este recurso de usuário
public class UserResource {

//    @GetMapping // responde requisições get
//    public ResponseEntity<User> retorneTodos() {
//        return ResponseEntity.ok().body(); // corpo da resposta deve conter u
//    }
    // diz que a resposta é do tipo usuário
}
