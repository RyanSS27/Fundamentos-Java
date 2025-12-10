import java.util.Random;
import java.util.Scanner;

public class Luta {
    private Scanner sc;
    private Combatentes desafiante;
    private Combatentes desafiado;
    private int rounds = 4;
    private boolean aprovada;

    public void marcarLuta(Combatentes pdesafiante, Combatentes pdesafiado, Scanner psc) {
        if (this.desafiante.getCategoria().equals(this.desafiado.getCategoria()) && this.desafiado != this.desafiante && this.desafiante.getCategoria() != "Inválido") {
            this.desafiante = pdesafiante;
            this.desafiado = pdesafiado;
            this.sc = psc;
            this.aprovada = true;
        } else {
            this.aprovada = false;
        }
    }

    private void lutar() {
        if (this.aprovada){
            System.out.println("====== IT'S TIME!\nApresentando o desafinte da noite... Ele mesmo: ");
            this.desafiante.apresentar();
            System.out.println("\n====== QUE HOJE DESAFIA: ");
            this.desafiado.apresentar();

            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3); // 0 1 2
            switch (vencedor) {
                case 0:
                    System.out.println("O desafiante " + this.desafiante.getNome() + " venceu o duelo!");
                    this.desafiante.setGanhar();
                    this.desafiado.setPerder();
                    break;
                case 1:
                    System.out.println("O desafiado " + this.desafiante.getNome() + " venceu o duelo!");
                    this.desafiante.setPerder();
                    this.desafiado.setGanhar();
                    break;
                default:
                    System.out.println("EMPATE!");
                    this.desafiante.setEmpatar();
                    this.desafiado.setEmpatar();
                    break;
            }
        } else {
            System.out.println("A luta não pode ser realizada.");
        }
    }
}
