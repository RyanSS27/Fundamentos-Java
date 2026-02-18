public class LimparTerminal {
    public static void limparTerminalANSI() {
        // \033[H - Move o cursor para a posição inicial (linha 1, coluna 1)
        // \033[2J - Limpa a tela inteira
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Garante que o buffer de saída seja esvaziado imediatamente
    }
}
