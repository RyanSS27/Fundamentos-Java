import java.util.ArrayList;
import java.util.List;

public class Parte1 {
    public static void main(String[] args) {
        List<String> listCompras = new ArrayList<>();
        listCompras.add("Ovo");
        listCompras.add("Óleo");
        listCompras.add("Detergente");
        listCompras.add("Lâmpada");

        System.out.println("------------------");
        for (String item : listCompras) {
            System.out.println(item);
        }
        System.out.println("------------------");

        //Pode adicionar colocando a posição que o elemento ocupará
        listCompras.add(0, "PRIORIDADE: leite");
        System.out.printf("Lista com %d itens\n", listCompras.size()); //Size pega o tamanho
        for (String item : listCompras) {
            System.out.println(item);
        }

        System.out.println("------------------");

        //Removendo itens
        System.out.println("Removendo um dado por posição (pos: 3 - Detergente):");
        listCompras.remove(3);
        System.out.println("Removendo um dado por comparação (\"Óleo\"):");
        listCompras.remove("Óleo");
        for (String item : listCompras) {
            System.out.printf("    - %s\n",item);
        }

            //Removendo por predicado - expressões que retornam True or False (Lembra do Frare?..)
        System.out.println("Removendo através de predicado, onde a inicial seja igual a \"L\":");
        listCompras.removeIf(x -> x.charAt(0) == 'L');
        for (String item : listCompras) {
            System.out.printf("    - %s\n",item);
        }
        System.out.println("------------------");
        System.out.println("Ovo está na pos: " + listCompras.indexOf("Ovo"));
    }
}
