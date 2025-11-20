import javax.swing.*;
import java.util.Locale;


//COMEÇO DOS MEUS ESTUDOS EM JAVA
public class Main {
    public static void main(String[] args){
        System.out.println("Hello, world!");

        //TIPAGENS
        //Integer: long > int > short > byte
        int id = 0;

        //Float point: double > float
        double saldo = 2562.50;

        //Caracters: String > char
        char resposta = 's';
        String nome = "Ryan";

        //Boolean: boolean (false or true)
        boolean estaLogado = false;

        //ENTRADA E SAÍDA
        System.out.println("O usuário " + nome + ", de ID " + id + ", possui:");
        System.out.printf("Saldo: R$%.2f\n", saldo);

        String nomeMulher = "Agatha";
        short idade = 16;
        double renda = 830.50;
        //Igual a linguagem C, onde %d é inteiro, %f é float point e %s é strin g
        System.out.printf("%s tem %d anos e uma renda mensal de %.2f.\n", nomeMulher, idade, renda);
        Locale.setDefault(Locale.US);
    }
}

