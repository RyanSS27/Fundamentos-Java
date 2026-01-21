import org.w3c.dom.ls.LSOutput;

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
        List<String>  mantimentos = compras.stream().filter(x -> x.substring(0, 10).equals("Mantimento")).collect(Collectors.toList());
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
    }
}
