import org.w3c.dom.ls.LSOutput;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parte2 {
    public static void main(String[] args) {
        List<String> compras = new ArrayList<>();
        compras.add("Mantimento: Ovo");
        compras.add("Limpeza: Detergente");
        compras.add("Mantimento: Óleo");
        compras.add("Mantimento: Azeite");
        compras.add("Limpeza: Alvejante");
        compras.add("Mantimento: Carnes");
        compras.add("Limpeza: Sabão em pó");
        compras.add("Mantimento: Achocolatado");

        // Separando mantimentos
        List<String>  mantimentos = compras.stream().filter(x -> x.substring(0, 10).equals("Mantimento")).toList();
        System.out.printf(mantimentos.toString());
        for (String itens : mantimentos) {
            System.out.println(itens);
        }

        String name = mantimentos.stream().filter(x -> x.charAt(12) == 'A').findFirst().orElse(null);
        System.out.println("------------------------");
        System.out.println("1° mantimento que começa com 'A':" + name);

        // Ordenando a lista
        System.out.println("=========================");
        compras.add("Mantimento: Alface");
        compras.add("Limpeza: Sabão em pó");
        compras.add("Limpeza: Alvejante");
        compras.add("Mantimento: Pão de alho");
        Collections.sort(compras);
        compras.forEach(item -> System.out.println(item));

        /*
            Testando a mutabilidade entre toList() e .collect(Collectors.toList())
            List<Integer> inteiros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
            List<Integer> pares = inteiros.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
            pares.set(0, 5);
            System.out.printf(pares.toString());
         */
    }
}
