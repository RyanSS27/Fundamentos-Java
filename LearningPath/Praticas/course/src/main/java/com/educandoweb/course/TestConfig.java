package com.educandoweb.course;

import com.educandoweb.course.model.Order;
import com.educandoweb.course.model.User;
import com.educandoweb.course.repository.OrderRepository;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

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
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        // Faz seeding no database (popula)
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null,"Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null,"Ryan", "fogarelGratis@gmailcom", "(98) 29857-3389", "1234");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
        orderRepository.saveAll(List.of(o1, o2, o3));
    }
}
