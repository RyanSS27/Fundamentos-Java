package exercicio77;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        /*
        * Calculator tem os métodos que realizam os cálculos.
        * Entretanto, eles não são estáticos, logo, se deve
        * instanciar o objeto para poder usá-los.
        */
        Calculator1 calc = new Calculator1();

        System.out.println("CALCULANDO A CIRCUNFERÊNCIA E O VOLUME DE UMA ESFERA\nDigite o raio:");
        double radius = sc.nextDouble();
        System.out.printf("\nUma esfera de raio %f, terá uma circunferência de: %f\n", calc.circunference(radius));

        System.out.printf("Seu volume será de: %.2f", calc.volume(radius));
    }
}
