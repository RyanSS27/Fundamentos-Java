package exercicioPenisonato;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locatario[] quartos = new Locatario[10];
        System.out.println("Quantos quartos deseja alugar?");
        int quantidade = sc.nextInt();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Qual o quarto? [0-9]");
            int quarto = sc.nextInt();
            sc.nextLine();
            quartos[quarto] = new Locatario();
            System.out.println("Nome do locatário: ");
            quartos[quarto].nome = sc.nextLine();
            System.out.println("Email de contato:");
            quartos[quarto].email = sc.nextLine();
        }

        System.out.println("LISTAGEM DOS QUARTOS ALUGADOS");
        for (int i = 0; i < quartos.length; i++) {
            if (quartos[i] != null) {
                System.out.printf("---- Quarto %d\n", i);
                System.out.println(quartos[i].nome);
                System.out.println(quartos[i].email);
            }
        }

        System.out.println(quartos.length);
        sc.close();
    }
}
