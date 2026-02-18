package exercicio77;

public class Calculator1 {
    public final double PI = 3.14;

    public double circunference(double radius) {
        return 2.0 * this.PI * radius;
    }

    public double volume(double radius) {
        return 4.0 * PI * Math.pow(radius, 3) / 3;
    }
}
