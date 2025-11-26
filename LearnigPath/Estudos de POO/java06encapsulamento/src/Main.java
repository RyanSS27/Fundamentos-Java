import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayStation2 ps2 = new PlayStation2("Slim", true);
        sc.useLocale(Locale.US);

        int i = 0;
        int decisaoUsuario;
        do {
            System.out.println("=====================================");
            System.out.println("       PLAYSTATION 2 INTERFACE       ");
            System.out.println("=====================================");
            System.out.println("[1] Ligar(start game)/desligar.");
            System.out.println("[2] Abrir console.");
            System.out.println("[3] Conferir status.");
            System.out.println("[4] Encerrar programa.");
            System.out.println("=====================================");
            System.out.println("Digite sua ação: ");
            decisaoUsuario = sc.nextInt();
            System.out.println("=====================================");

            switch (decisaoUsuario) {
                case 1:
                    ps2.ligarDesligar(sc);
                    break;
                case 2:
                    ps2.abriConsole(sc);
                    break;
                case 3:
                    ps2.visualizarConsole();
                    break;
                case 4:
                    System.out.println("Encerrando o programa!.");
                    decisaoUsuario = 4;
                    break;
                default:
                    System.out.println("Decisão inválida! Tente novamente.");
            }
        } while (decisaoUsuario != 4);
    }
}
