package aplicacao;

import utilitarios.ConversorMoeda;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        //  Com o Dólar valendo 3.1 reais + a porcentagem do IOF sob o valor bruto,
        //  para se obter 200 dólares, terá de converter R4657.2...
        System.out.println("Digite quantos reais vale 1 Dólar Americano:");
        double dolar = sc.nextDouble();
        System.out.println("Quantos dólares deseja comprar:");
        double reais = sc.nextDouble();

        System.out.println("Com a taxa sob a conversão sendo IOF de " + ConversorMoeda.IOF + "%, terá de pagar: " + ConversorMoeda.converter(reais, dolar));

        sc.close();
    }
}
