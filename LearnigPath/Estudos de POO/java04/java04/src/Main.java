import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LimparTerminal lp = new LimparTerminal();
        PlayStation2 ps2 = new PlayStation2();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int i = 0;
        do {
            System.out.println("=====================================");
            System.out.println("       PLAYSTATION 2 INTERFACE       ");
            System.out.println("=====================================");
            System.out.println("[1] Ligar(start game)/desligar.");
            System.out.println("[2] Abrir console.");
            System.out.println("[3] Conferir status.");
            System.out.println("[4] Encerrar programa.");
            System.out.println("=====================================");
            System.out.printf("Digite sua ação: ");
            int decisaoUsuario = 0;
            decisaoUsuario = sc.nextInt();
            System.out.println("=====================================");

            switch (decisaoUsuario) {
                case 1:
                    ps2.setLigarDesligar();
                break;
                case 2:
                    ps2.getAbrirConsole();
                break;
                case 3:
                    ps2.getStatus();
                break;
                case 4:
                    System.out.println("Encerrando o programa!.");
                    i++;
                break;
                default:
                    System.out.println("Decisão inválida! Tente novamente.");
            }
        } while (i < 1);
    }
}
