package com.educandoweb.course;

import com.educandoweb.course.model.*;
import com.educandoweb.course.model.enums.OrderStatus;
import com.educandoweb.course.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        // Faz seeding no database (popula)
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null,"Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null,"Ryan", "fogarelGratis@gmailcom", "(98) 29857-3389", "1234");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
        orderRepository.saveAll(List.of(o1, o2, o3));

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");
        categoryRepository.saveAll(List.of(c1, c2, c3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", BigDecimal.valueOf(90.5), "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", BigDecimal.valueOf(2190.0), "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", BigDecimal.valueOf(1250.0), "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", BigDecimal.valueOf(1200.0), "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", BigDecimal.valueOf(100.99), "");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(List.of(oi1, oi2,oi3, oi3, oi4));
    }
}
