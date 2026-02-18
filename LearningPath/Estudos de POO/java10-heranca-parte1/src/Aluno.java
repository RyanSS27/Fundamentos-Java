public class Aluno extends Usuario {
    private int matricula;
    private String curso;

    public Aluno(String nome, int idade, char sexo, int matricula, String curso) {
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
        this.matricula = matricula;
        this.curso = curso;
    }
    public String cancelarMatricula() {
        return "O aluno %s teve a matrícula %d cancelada.".formatted(getNome(), this.matricula);
    }
}
