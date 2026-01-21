import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float length, width, metragem, precoPorMetroQuadrado;
        System.out.println("Digite o comprimento:");
        length = sc.nextFloat();
        System.out.println("Digite a largura do terreno:");
        width = sc.nextFloat();
        System.out.println("Digite o preço por metro quadrado da região:");
        precoPorMetroQuadrado = sc.nextFloat();
        metragem = length * width;
        System.out.printf("O terreno possui %.2f m^2, tendo valor de mercado de R$%.2f na região.", metragem, precoPorMetroQuadrado * metragem);

        sc.close();
    }
}