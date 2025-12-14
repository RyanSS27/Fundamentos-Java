public class Tecnico extends Aluno {
    private String registroProfissional;
    public void praticar() {
        System.out.println("Tô estudando paizão.");
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }
}
