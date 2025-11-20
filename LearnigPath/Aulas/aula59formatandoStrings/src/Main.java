//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("TESTES DE FORMATAÇÃO");
        System.out.printf("String original deveria ser 'Teste Simples'.");

        String original = "Teste Simples".toLowerCase();
        System.out.println(original);

        System.out.println(original.toUpperCase());

        //REPLACE
        original = original.replace('e', 'o');
        System.out.println(original);
        original = original.replace("tosto", "Ryan");
        System.out.println(original);

        //FUNÇÃO TRIM()
        original = "   " + original + "   ";
        System.out.println(original);
        String copiaSemEspacos = original.trim();
        System.out.println(copiaSemEspacos);

        //SUBSTRING(inicio, fim)
        System.out.println(original.trim().substring(0, 4));

        //INDEXOF("")
        String string = "Ultima ocorrencia de \"Ul\"";
        System.out.println(string);
        System.out.println(string.indexOf("rr")); //realiza a contagem tomando o U como 0
        //O comando deve retornar a última pcprrência em que Ul aparece (nesse caso, é no fim)
        System.out.println((string.lastIndexOf("Ul")));

        //SPLIT
        System.out.println("Funcionamento do Split");
        //separa a string em pedações e armazena cada um em uma parte do vetor
        //ele separa de acordo com o caracter de que vc definir como "barreira"
        String data = "20/06/2000";
        String dataFormatada[] = data.split("/");
        System.out.println("Data padrão: " + data);
        for (int i = 0; i < 3; i++)
            System.out.println(dataFormatada[i]);

        String textoSemEspaco[] = "Texto com espaços".split(" ");
        for (int i = 0; i < 3; i++)
            System.out.println(textoSemEspaco[i]);
    }
}