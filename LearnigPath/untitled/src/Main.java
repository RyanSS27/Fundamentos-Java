import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int i = sc.nextInt();
        if (i < 0) {
            System.out.println("Este número é negativo: " + i);
        } else {
            System.out.printf("O número %d é positivo.\n", i);
        }

        if (i%2==0) {
            System.out.printf("Além disso número %d é par\n", i);
        } else {
            System.out.printf("Além disso número %d é ímpar\n", i);
        }

        System.out.println("\nDigite outro número:");
        int j = sc.nextInt();

        if(i > j) {
            if (i%j==0) {
                System.out.printf("Os números %d e %d são multiplos.", i, j);
            } else {
                System.out.printf("Os número %d e %d não são multiplos", i, j);
            }
        } else {
            if (j%i==0) {
                System.out.printf("Os números %d e %d são multiplos.", i, j);
            } else {
                System.out.printf("Os número %d e %d não são multiplos", i, j);
            }
        }
    }
}