public class Pessoa {
    private  String nome;
    private int idade;
    private char sexo;

    public Pessoa(String n, int i, char s) {
        this.nome = n;
        this.idade = i;
        this.sexo = s;
    }

    public void fazerAniversario() {
        this.idade++;
    }
    public String getNome() {
        return this.nome;
    }
}
