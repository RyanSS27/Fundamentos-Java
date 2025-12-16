public class Professor extends Usuario {
    private String disciplina;
    private float salario;

    public Professor(String nome, int idade, char sexo, String disciplina, float salario) {
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public String setDisciplina(String novaDisc) {
        this.disciplina = novaDisc;
        return "Disciplina alterada!";
    }
}
