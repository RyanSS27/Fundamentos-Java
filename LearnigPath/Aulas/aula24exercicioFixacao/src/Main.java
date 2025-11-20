import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String produto1 = "Computador";
        double preco1 = 2500;
        String produto2 = "Mesa de escritório";
        double preco2 = 650.50;

        System.out.println("PRODUTOS");
        System.out.printf("%s, com preço R$ %.2f\n", produto1, preco1);
        System.out.printf("%s, com preço R$ %.2f\n", produto2, preco2);

        System.out.println("REGISTRO");
        int idade = 30;
        int codigo = 5496;
        char sexo = 'F';
        double medida = 82.649853;

        System.out.printf("Registro do cliente: %d anos de idade, código %d, sexo %s.\n", idade, codigo, sexo);
        System.out.printf("Medida do local com 8 casas decimais: %.8f\n", medida);
        System.out.printf("Medida arredonda (3 casas decimais): %.3f\n",medida);
        Locale.setDefault(Locale.US);
        System.out.printf("Medida padrão USA: %.3f\n",medida);
    }
}