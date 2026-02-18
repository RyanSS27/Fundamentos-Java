import java.util.Scanner;
// Contexto, ao que entendi do exercício, é como se cada livro tivesse um dono e você é como
// um terceiro, que pode verificar os livros das pessoas. Assim, usei o contexto estudantes
// que reservaram livros e o terceiro (código) é o bibliotecário vistoriando
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa[] estudantes = {
                new Pessoa("Ryan", 19, 'm'),
                new Pessoa("Agatha", 16, 'f')
        };
        // Carregando a estante
        Livro[] estante = {
                new Livro("Clean Code", "Robert C. Martin", 464, estudantes[0]),
                new Livro("Effective Java", "Joshua Bloch", 412, estudantes[1]),
                new Livro("Design Patterns", "Erich Gamma", 395, estudantes[1]),
                new Livro("Refactoring", "Martin Fowler", 448, estudantes[0]),
                new Livro("The Pragmatic Programmer", "Andrew Hunt", 352, estudantes[0]),
                new Livro("Modern Java in Action", "Raoul-Gabriel Urma", 592, estudantes[1])
        };

        for (int i = 0; i < 6; i++) {
            System.out.println(estante[i].detalhes());
        }


        System.out.println(estante[2].abreFecha());
        System.out.println(estante[2].folhear());
        System.out.println(estante[2].avancarPag());
        System.out.println(estante[2].voltarPag());
        System.out.println(estante[2].abreFecha());
    }
}