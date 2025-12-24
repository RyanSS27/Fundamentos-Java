package exercicio02;

public class Exercicio02 {
    public static void main(String[] args) {
        Aluno alunos[] = {
                new Aluno("Mano 1"),
                new Aluno("Mano 2")
        };

        System.out.println(alunos[0].mediasSemestre(1, 10.0d, 9.5d, 6.0));
        System.out.println(alunos[0].mediasSemestre(2, 7.75, 6.0d, 8.0d));
        System.out.println(alunos[0].mediasSemestre(3, 9.0d, 3.5d, 6.0));
        System.out.println(alunos[0]);
        System.out.println("======================================================");
        alunos[1].mediasSemestre(1, 6.0d, 7.5d, 6.0d);
        alunos[1].mediasSemestre(2, 4.75d, 3.0d, 6.0d);
        System.out.println(alunos[1].mediasSemestre(3, 7.0d, 3.5d, 6.0));
        System.out.println(alunos[1]);
    }
}
