package entities;

public class OrderItem {
    private final int quantity;
    private final double price;
    private final Product product;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }


    public double subTotal(){return quantity*price;}

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("------\n");
        description.append("Produto: ").append(product.getName()).append("\n")
            .append("Preço: ").append(price).append("\n")
            .append("Quantidade: ").append(quantity).append("\n")
            .append("Sub total: R$").append(subTotal());
        return description.toString();
    }
}
