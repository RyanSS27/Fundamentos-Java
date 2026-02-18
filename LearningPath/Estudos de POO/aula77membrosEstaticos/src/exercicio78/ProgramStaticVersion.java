package exercicio78;

import java.util.Locale;
import java.util.Scanner;


public class ProgramStaticVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        /*
        * Como o método PI foi declarado como static, não é gerado na memória
        * um pedaço na memória exclusivo para cada objeto que foi instanciado,
        * é gerado um espaço na memória com o valor que todos objeto e a classe
        * tem acesso.
        *
        * Assim, você não precisa instanciar um objeto, pode usar seus métodos
        * e atributos constantes através da própria classe.
        */

        System.out.println("CALCULANDO A CIRCUNFERÊNCIA E O VOLUME DE UMA ESFERA\nDigite o raio:");
        double radius = sc.nextDouble();

        System.out.printf("\nUma esfera de raio %.2f, terá uma circunferência de: %.2f\n", radius, Calculator.circunference(radius));
        System.out.printf("Seu volume será de: %.2f\nTomando PI como %f%n", Calculator.volume(radius), Calculator.PI);
    }
}
