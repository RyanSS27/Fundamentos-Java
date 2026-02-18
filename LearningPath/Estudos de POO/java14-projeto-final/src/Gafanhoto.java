public final class Gafanhoto extends Pessoa {
    private String login;
    private int totAssistido;

    public Gafanhoto(String nome, int idade, char sexo, String login) {
        super(nome, idade, sexo);
        this.login = login;
        this.totAssistido = 0;
    }

    public void viuMaisUm() {
        this.totAssistido++;
    }

    @Override
    public String toString() {
        return "Gafanhoto{" +
                "experiencia=" + experiencia +
                ", sexo=" + sexo +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", totAssistido=" + totAssistido +
                '}';
    }
}
