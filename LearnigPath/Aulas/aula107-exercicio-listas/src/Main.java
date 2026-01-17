import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        List<Empregado> caboclos = new ArrayList<>();
        System.out.println("Quantos cablocos trabalham para você?");
        int y = sc.nextInt();
        for (int i = 0; i<y; i++) {
            System.out.println("Digite o id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite o nome:");
            String nome = sc.nextLine();
            System.out.println("Digite o salario:");
            float sal = sc.nextFloat();
            caboclos.add(new Empregado(id, nome, sal));
        }

        System.out.println("Digite o id do funcionário que terá o salário aumentado:");
        int id = sc.nextInt();
        Empregado sortudo = caboclos.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (sortudo != null) {
            System.out.println("Digite a porcentagem de aumento:");
            int p = sc.nextInt();
            sortudo.receberAumento((float) p);
        } else {
            System.out.println("Funcionário não encontrado");
        }

        for (Empregado e : caboclos) {
            System.out.println(e);
        }
        sc.close();
    }
}
