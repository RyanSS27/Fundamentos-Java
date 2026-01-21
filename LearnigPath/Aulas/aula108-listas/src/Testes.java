import java.util.ArrayList;
import java.util.List;

public class Testes {
    public static void main(String[] args) {
        List<Integer> num  = new ArrayList<>();
        for (int i = 3; i <= 30; i += 3) num.add(i);
        num.forEach(x -> System.out.println(x));

        num.remove(3);
        num.forEach(x -> System.out.println(x));


        List<String> teste = new ArrayList<>();
        teste.add("Teste");
        teste.add("Teste");
        teste.add("Não sei");
        System.out.println(teste);
        teste.remove("Teste");
        System.out.println(teste);
    }
}
