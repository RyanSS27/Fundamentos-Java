// O QUE EU TENHO? - Atributos
// Versão (Fat, Slim, Pro)
// Bloqueado/desbloqueado

// COMO ESTOU? - Atrbutos de estado
// Conteúdo: vazio/com game
// Estado: aberto/fechado/em game

//O QUE EU FAÇO? - Métodos
// Abrir/fechar
// Ligar/desligar
// Tirar/trocar/colocar jogo
// Rodar jogo

import java.util.Scanner;

public class PlayStation2 implements InterfacePs2 {
    private final String modelo;
    private boolean bloqueado;

    private boolean ocupado; // Tem jogo == true / sem jogo == false
    private String jogo;
    private String estado; // ligado/desligado/aberto

    public PlayStation2(String parModelo, boolean parBloqueado) {
        this.modelo = parModelo;
        this.bloqueado = parBloqueado;
        this.ocupado = false;
        this.jogo = "";
        this.estado = "desligado";
    }

    private void internoLigarDesligar(Scanner sc) {
        if (this.estado.equals("ligado")) {
            this.estado = "desligado";
            System.out.println("Desligando...\nAtividade encerrada.");
        } else if (this.estado.equals("desligado") && this.ocupado) {
            this.estado = "ligado";
            System.out.println("_____________________________________");
            System.out.println(" __  __    _  _____ ____  ___ __  __");
            System.out.println("|  \\/  |  / \\|_   _|  _ \\|_ _|\\ \\/ /");
            System.out.println("| |\\/| | / _ \\ | | | |_) || |  \\  / ");
            System.out.println("| |  | |/ ___ \\| | |  _ < | |  /  \\ ");
            System.out.println("|_|  |_/_/   \\_\\_| |_| \\_\\___|/_/\\_\\");
            System.out.println("_____________________________________");
            int i = 0, escolhaOpcao;

            do {
                System.out.println("=====================================");
                System.out.println("MENU DO JOGO (CONSOLE LIGADO)");
                System.out.println("[1] Desligar e sair do jogo.");
                System.out.println("[2] Conferir console.");
                System.out.println("=====================================");
                System.out.print("Digite sua escolha: ");

                escolhaOpcao = sc.nextInt();

                switch (escolhaOpcao) {
                    case 1:
                        this.estado = "desligado";
                        System.out.println("Desligando o sistema...");
                        i++; // Incrementa i para sair do loop while (i < 1)
                        break;
                    case 2:
                        this.internoVisualizarConsole();
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } while (i < 1);
        } else {
            System.out.println("Antes de iniciar, insira algum jogo.");
        }
    }

    private void internoAbrirConsole(Scanner sc) {
        System.out.println("  ---------------------------------------");
        System.out.println("  |             |                       |");
        System.out.println("  |             |      .---------.      |");
        System.out.println("  |     PS2     |     /     _     \\     |"); // Compartimento do disco
        System.out.println("  |             |    |    ( O )    |    |"); // Leitor óptico no centro
        System.out.println("  |   ///////   |    |      -      |    |");
        System.out.println("  |             |     \\._________./     |");
        System.out.println("  |_____________|_______________________|");
        System.out.println("  | [MEMORY SLOT]  [OPEN]      [START]  |"); // Painel frontal
        System.out.println("   ------------------------------------- ");
        this.estado = "aberto";
        int escolhaUsuario, i = 0;
        if (this.ocupado) {
            do {
                System.out.println("O console está ocupado com um jogo.\nQual ação deseja tomar?");
                System.out.println("=====================================");
                System.out.println("[1] Trocar o jogo.");
                System.out.println("[2] Remover jogo.");
                System.out.println("[3] Conferir status.");
                System.out.println("[4] Tampar novamente e voltar.");
                System.out.println("=====================================");
                System.out.println("Digite sua ação: ");
                escolhaUsuario = sc.nextInt();
                System.out.println("=====================================");
                switch (escolhaUsuario) {
                    case 1:
                        System.out.printf("Jogo atual: %s \nDigite o jogo que deseja inserir no lugar:\n", this.jogo);
                        sc.nextLine();
                        this.jogo = sc.nextLine();
                        System.out.println("Jogo inserido com sucesso e o outro devolvido a case!\nFEchando o console e retornando");
                        this.estado = "desligado";
                        break;
                    case 2:
                        System.out.println(this.ocupado? "O jogo foi removido.": "Não há jogo a ser removido no console.");
                        this.ocupado = false;
                        this.jogo = "";
                        this.estado = "desligado";
                        i++;
                        break;
                    case 3:
                        this.internoVisualizarConsole();
                        break;
                    case 4:
                        this.estado = "desligado";
                        System.out.println("Console tampado.");
                        i++;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, digite um número entre 1 e 4.");
                        break;
                }
            } while (i < 1);

        } else {
            do {
                System.out.println("O console está sem jogos no momento.\nQual ação deseja tomar?");
                System.out.println("=====================================");
                System.out.println("[1] Inserir um jogo.");
                System.out.println("[2] Conferir status.");
                System.out.println("[3] Tampar novamente e voltar.");
                System.out.println("=====================================");
                System.out.println("Digite sua ação: ");
                escolhaUsuario = sc.nextInt();
                System.out.println("=====================================");
                switch (escolhaUsuario) {
                    case 1:
                        System.out.println("Digite o jogo que deseja inserir:");
                        sc.nextLine();
                        this.jogo = sc.nextLine();
                        System.out.printf("Jogo %s inserido com sucesso e o console foi tampado!\n", this.jogo);
                        this.estado = "desligado";
                        this.ocupado = true;
                        i++;
                        break;
                    case 2:
                        this.internoVisualizarConsole();
                        break;
                    case 3:
                        this.estado = "desligado";
                        System.out.println("Console tampado.");
                        i++;
                    default:
                        System.out.println("Opção inválida. Por favor, digite um número entre 1 e 3.");
                        break;
                }
            } while (i < 1);
        }
    }

    public void internoVisualizarConsole() {
        System.out.println("Bora conferir o console!");
        System.out.printf("Seu PS2 é do modelo: %s%s\n", this.modelo, this.bloqueado ? " bloqueado." : " desbloqueado.");
        System.out.printf("Atualmente ele está %s\n", this.estado);
        System.out.println(this.ocupado ? "Contém o jogo " + this.jogo + "." : "Está sem jogos no momento.");
    }

    @Override
    public void ligarDesligar(Scanner sc) {
        //Está redundante, mas futuramente outras opções de controle serão implementadas
        internoLigarDesligar(sc);
    }

    @Override
    public void abriConsole(Scanner sc) {
        //Está redundante, mas futuramente outras opções de controle serão implementadas
        internoAbrirConsole(sc);
    }

    @Override
    public void visualizarConsole() {
        internoVisualizarConsole();
    }
}
