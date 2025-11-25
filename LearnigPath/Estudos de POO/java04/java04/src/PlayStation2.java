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

public class PlayStation2 {
    Scanner sc = new Scanner(System.in);
    private String modelo;
    private boolean bloqueado;

    private boolean ocupado; // Tem jogo == true / sem jogo == false
    private String jogo;
    private String estado; // ligado/desligado/aberto

    public PlayStation2() {
        this.modelo = "Slim";
        this.bloqueado = true;
        this.ocupado = false;
        this.jogo = "";
        this.estado = "desligado";
    }

    public void setLigarDesligar() {
        if (this.estado == "ligado") {
            this.estado = "desligado";
            System.out.println("Desligando...\nAtividade encerrada.");
        } else if (this.estado == "desligado" && this.ocupado) {
            this.estado = "ligado";
            System.out.println("Iniciando...\nMATRIX\nJogo ligado");
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
                        this.getStatus();
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } while (i < 1);
        } else {
            System.out.println("Antes de inciar, insira algum jogo.");
        }
    }

    public void getAbrirConsole() {
        System.out.println("=====================================");
        System.out.println("            TAMPA ABERTA             ");
        System.out.println("=====================================");
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
                escolhaUsuario = this.sc.nextInt();
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
                        this.estado = "deslligado";
                        i++;
                        break;
                    case 3:
                        this.getStatus();
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
                escolhaUsuario = this.sc.nextInt();
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
                        this.getStatus();
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

    public void getStatus() {
        System.out.println("Bora conferir o console!");
        System.out.printf("Seu PS2 é do modelo: %s%s\n", this.modelo, this.bloqueado ? " bloqueado." : " desbloqueado.");
        System.out.printf("Atualmente ele está %s\n", this.estado);
        System.out.println(this.ocupado ? "Contém o jogo " + this.jogo + "." : "Está sem jogos no momento.");
    }
}
//if (desejo == "abrir" && this.estado == "rodando") {
//            return "[ERRO] Antes, encerre a atividade corretamente.";
//        } else if(desejo == "abrir" && (this.estado == "aberto" || this.estado == "fechado")) {
//            this.estado = "aberto";
//            return "Console ABERTO.";
//        } else if(desejo == "fechar"){
//            this.estado = "fechado";
//            return "Console FECHADO.";
//        } if (desejo == "rodar" && this.estado == "aberto") {
//            return "Feche o console antes ligar.";
//        } else if (desejo == "rodar" && !this.ocupado) {
//            return "Insira um jogo antes de iniciar.";
//        } else if (desejo == "rodar") {
//            this.estado = "rodando";
//            return "MATRIZ\nLoading...\n[EM GAME]";
//        } else {
//            return "[ERRO] Desejo inválido";
//        }