package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private Client client;
    private final LocalDateTime dateTime;
    private List<OrderItem> orderItems = new ArrayList<>();
    private OrderStatus status;


    public Order(Client client, LocalDateTime dateTime, OrderStatus status) {
        this.client = client;
        this.dateTime = dateTime;
        this.status = status;
    }

    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public double total() {
        if(orderItems.isEmpty()) return 0;
        double total = 0;
        for(OrderItem i: orderItems) {
            total += i.subTotal();
        }
        return total;
    }

    public OrderItem getOrder(int index) {
        return orderItems.get(index);
    }

    public String orderSummary() {
        StringBuilder sumarry = new StringBuilder();
        sumarry.append("Cliente: ").append(client.getName())
                .append("\nData do pedido: ")
                .append(format.format(dateTime));

        for (OrderItem x : orderItems)
            sumarry.append("\n").append(x);

        sumarry.append("\n===========\n")
                .append("Valor total: R$%.2f".formatted(total()));
        return sumarry.toString();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
