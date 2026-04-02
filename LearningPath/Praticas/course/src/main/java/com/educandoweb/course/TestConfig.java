package com.educandoweb.course;

import com.educandoweb.course.model.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/*
    Diz ao Spring que esta é uma classe de configuração que
    só deve ser rodada quando estivermos no perfil de "test"
    (perfil ativo lá em properties):

    spring.profiles.active=test
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        // Faz seeding no database (popula)
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null,"Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null,"Ryan", "fogarelGratis@gmailcom", "(98) 29857-3389", "1234");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
