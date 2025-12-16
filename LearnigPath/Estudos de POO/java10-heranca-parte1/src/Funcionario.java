public class Funcionario extends Usuario {
    private String cargo;
    private float salario;
    private boolean trabalhando;

    public Funcionario(String nome, int idade, char sexo, float salario, boolean trabalhando) {
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
        this.trabalhando = trabalhando;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public boolean setTrabalhando() {
        this.trabalhando = !this.trabalhando;
        return this.trabalhando;
    }
}
