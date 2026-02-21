import entities.Order;
import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listaShow = new ArrayList();
        listaShow.add(1);
        listaShow.add(2);
        listaShow.add(3);
        System.out.println(listaShow);
        Order clientOrder = new Order(325, LocalDateTime.now(), OrderStatus.PENDING_PAYMENT);
        System.out.println(clientOrder);
        // Convertendo uma String para uma estância do tipo enumerado

        OrderStatus os1 = OrderStatus.PENDING_PAYMENT;
        OrderStatus os2 = OrderStatus.valueOf("PROCESSING");

        System.out.println(os1);
        System.out.println(os2);
    }
}
