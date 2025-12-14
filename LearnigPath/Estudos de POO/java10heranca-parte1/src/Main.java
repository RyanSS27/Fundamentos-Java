import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Testando Aluno
        // Comum: Herança de Usuario (Nome, Idade, Sexo)
        // Especialista em: Matrícula, Curso, cancelarMatricula()
        var aluno = new Aluno("João Silva", 20, 'M', 202301, "Engenharia de Software");

        System.out.println("=== TESTE ALUNO ===");
        System.out.println("Aluno (comum): " + aluno.getNome());
        System.out.println("Idade (comum): " + aluno.getIdade());
        System.out.println("Sexo (comum): " + aluno.getSexo());
        System.out.println("Ação (Especialista): " + aluno.cancelarMatricula());

        // 2. Testando Funcionário
        // Comum: Herança de Usuario
        // Especialista em: Salário, Trabalhando, setTrabalhando()
        var funcionario = new Funcionario("Maria Oliveira", 35, 'F', 2500.50f, true);

        System.out.println("\n=== TESTE FUNCIONÁRIO ===");
        System.out.println("Func. (Comum): " + funcionario.getNome());
        System.out.println("Idade (comum): " + funcionario.getIdade());
        System.out.println("Sexo (comum): " + funcionario.getSexo());
        System.out.println("Salário (Especialista): R$ " + funcionario.getSalario());
        System.out.println("Status alterado (Especialista): " + (funcionario.setTrabalhando() ? "Trabalhando" : "Parado"));

        // 3. Testando Professor
        // Comum: Herança de Usuario
        // Especialista em: Disciplina, Salário, setDisciplina()
        var professor = new Professor("Dr. Roberto", 50, 'M', "Matemática", 5500.00f);

        System.out.println("\n=== TESTE PROFESSOR ===");
        System.out.println("Prof. (Comum - Nome): " + professor.getNome());
        System.out.println("Idade (comum): " + aluno.getIdade());
        System.out.println("Sexo (comum): " + aluno.getSexo());
        // setDisciplina retorna uma String confirmando a alteração
        System.out.println("Ação (Especialista): " + professor.setDisciplina("Física Quântica"));
    }
}
