import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char resp;
        System.out.println("===============================================");
        System.out.println("              JOGO DA ADIVINHAÇÃO              ");
        System.out.println("===============================================");
        System.out.println("Neste jogo, quando você perde, sua alma é consumida.");
        System.out.println("Mas fique tranquilo, eu sei que você consegue.");
        do {
            System.out.println("===============================================");
            System.out.println("Deseja jogar? [s/n]");
            resp = sc.next().trim().toLowerCase().charAt(0);
            switch (resp) {
                case 's':
                    short teste = 0, tentativas = 0;
                    while (teste == 0) {
                        tentativas++;
                        short nRandom = (short)(ThreadLocalRandom.current().nextInt(1, 11));
                        System.out.printf("Esta é sua %d° tentativa! Escolha um número de 1 a 10: ", tentativas);
                        short n = sc.nextShort();
                        if (n == nRandom) {
                            System.out.printf("=== Parabéns!!! Acertou na sua %d° tentativa.\n", tentativas);
                            teste++;
                        } else if (tentativas < 3) {
                            System.out.printf("--- Você errou! Mas vamos com calma, essa foi a sua %d.\n", tentativas);
                        } else {
                            System.out.println("--- Infelizmente não conseguiu, o número correto era "+ nRandom +". \nMas fica tranquilo, é só tentar de novo.");
                            teste++;
                        }
                    }
                    break;
                case 'n':
                    System.out.println("Obrigado por jogar!!! (Tá com medo?)");
                    break;
                default:
                    System.out.println("Sério que você sequer consegue digitar \"s\" ou \"n\"?\n Vou perguntar de novo: ");
                    break;
            }
        } while (resp != 'n');

        sc.close();
    }
}
