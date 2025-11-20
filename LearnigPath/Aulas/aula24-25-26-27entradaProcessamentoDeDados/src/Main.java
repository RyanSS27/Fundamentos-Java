import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Criando um objeto Scanner associado teclado do console
        Scanner sc = new Scanner(System.in);

        //Processo para strings de uma palavra
        System.out.println("Digite uma String de 1 palavra:");
        String nome;
        nome = sc.next();
        System.out.println(nome);

        //Processo para inteiros
        System.out.println("Digite um inteiro:");
        int x;
        x = sc.nextInt();
        System.out.println(x);

        //Processo para float point
        System.out.println("Digite um float:");
        float n;
        n = sc.nextFloat(); //Tem que digitar com a vírgula, pois o next, por padrão, pega a formatação do idioma da máquina
        //Locale.setDefault(Locale.US); deve ser colocado antes do Scanner sc[...]
        System.out.println(n);

        //Processo char
        System.out.println("Digite um char:");
        char testeChar;
        testeChar = sc.next().charAt(0);
        System.out.println(testeChar);

        //Processo string completa
        sc.nextLine();
        System.out.println("Digite o nome completo:");
        String nomeCompleto = sc.nextLine();
        System.out.printf("O nome digitado foi %s", nomeCompleto);












        //PROCESSAMENTO DE DADOS EM JAVA
        System.out.println("\n             PROCESSAMENTO DE DADOS EM JAVA             ");
        System.out.println("========================================================");
        System.out.println("Atribuição com tipagem diferente:");
        int a = 10;
        double b = 2 * a;
        System.out.printf("Por 'b' ser um double, recebendo a mult de 2 inteiros\no resultado é convertido: %f\n", b);


        System.out.println("Multiplicação de tipos diferentes (int e double):");
        int c = 3;
        double d = 10.0;
        System.out.println(d * c);

        System.out.println("Divisão entre numeros inteiros:");
        int e = 5, f = 2;
        double resultadoDivisao = (e/f);
        System.out.println("Resultado de 5/2 dá um int:" + resultadoDivisao);
        System.out.println("Com comando que solicita um double ao fim da divisão:");
        resultadoDivisao = (double) e/f;
        System.out.println(resultadoDivisao);

        e = (int) resultadoDivisao;
        System.out.println("Colocando um double (2,5) em um int: " + e);



        //Boas práticas:
        double num = 9.0;
        float num2 = 4f;


        sc.close();
    }
}