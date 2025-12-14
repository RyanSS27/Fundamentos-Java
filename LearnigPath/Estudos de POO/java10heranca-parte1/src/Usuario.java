public class Usuario {
    protected String nome;
    private int Idade;
    private char sexo;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return Idade;
    }

    public char getSexo() {
        return sexo;
    }
}






