package program;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Client client = new Client("Jucelino",  "éMafiaFamilia@gmail.com");
        List<Product> products = new ArrayList<>(List.of(
                // Salgados
                new Product("Coxinha de Frango", 8.50),
                new Product("Kibe com Requeijão", 9.00),
                new Product("Empada de Palmito", 8.00),

                // Bebidas
                new Product("Coca-Cola Lata", 6.50),
                new Product("Guaraná Antarctica", 6.00)
        ));

        // Simulação para não ter que lidar com entradas
        Order clientOrder = new Order(client, LocalDateTime.now(), OrderStatus.PROCESSING); // gerou uma comanda
        clientOrder.addItem(new OrderItem(products.get(0), 2));
        clientOrder.setStatus(OrderStatus.PENDING_PAYMENT);
        clientOrder.addItem(new OrderItem(products.get(3), 1));

        // teste: System.out.println(clientOrder.total());
        // teste: System.out.println(clientOrder.getOrder(1));
        System.out.println(clientOrder.orderSummary());
    }
}
