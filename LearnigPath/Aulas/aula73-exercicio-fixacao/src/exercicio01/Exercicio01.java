package exercicio01;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Funcionario peao = new Funcionario();
        Funcionario peao2 = new Funcionario();
        peao.setNome("Clodoaldo");
        peao.setImposto(10.0f);
        peao.setSalarioBruto(750);
        peao.aumento(10.0f);
        System.out.println(peao);

        peao.setNome("Charles");
        peao2.setSalarioBruto(1000);
        peao2.aumento(20);
        System.out.println(peao2);
    }
}
