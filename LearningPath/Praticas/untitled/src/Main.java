import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        String nomeProduto;
        int idProduto;
        float precoProduto;
        char tipoProduto;

        System.out.println("   CADASTRO DE PRODUTOS   ");
        System.out.println("==========================");
        System.out.println("Digite o nome do produto:");
        nomeProduto = sc.nextLine();
        System.out.println("Digite o ID do produto: ");
        idProduto = sc.nextInt();
        sc.nextLine();
        //Limpar o buffer (não era necessário, pois o sc.next().charAt(0) buscaria o primeiro caractere, "pulando o \n")
        //Aula 27, minuto 5 fala sobre a limpeza

        //E = eletrônico, V = vestuário, L = livro
        System.out.println("Digite o tipo do produto (E/V/L): ");
        tipoProduto = sc.next().charAt(0);
        System.out.println("Digite o preço do produto (padrão US): ");
        precoProduto = sc.nextFloat();
        System.out.println("==========================");
        System.out.println("    CÁLCULO DE IMPOSTO    ");

        //Alíquota (Porcentagem de Imposto): Deve ser calculada dividindo-se o Código do Produto (ID) por 100.
        float aliquota = (float) idProduto / 100;
        float imposto = aliquota * precoProduto;

        System.out.printf("Produto: %s\n", nomeProduto);
        System.out.printf("(Categoria: %c)\n", tipoProduto);
        System.out.printf("Preço: R$%.2f\n", precoProduto);
        System.out.printf("Aliquota: %.2f%%\n", aliquota * 100);
        System.out.printf("Imposto a pagar: R$%.2f\n", imposto);
    }
}