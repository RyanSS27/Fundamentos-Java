import Entities.Funcionario;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Funcionario peao = new Funcionario();
        Funcionario peao2 = new Funcionario();
        peao.setImposto(10.0f);
        peao.setSalario(750);
        peao.aumento(10.0f);
        System.out.println(peao);

        peao2.setSalario(1000);
        peao2.aumento(20);
        System.out.println(peao2);
    }
}
