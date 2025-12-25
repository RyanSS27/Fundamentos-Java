package utilitarios;

public class ConversorMoeda {
    public static final double IOF = 6.0;
    public static final double converter(double reais, double valorDoDolar) {
        return (reais * valorDoDolar)*(IOF/100+1);
    }
}
