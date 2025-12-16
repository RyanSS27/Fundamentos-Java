public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected char sexo;
    protected int experiencia;

    public Pessoa(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.experiencia = 0;
    }


    protected void ganharExp() {
        this.experiencia = this.experiencia + 10;
    }
}
