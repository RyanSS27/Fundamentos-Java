public final class Tecnico extends Aluno {
    private String registroProfissional;
    public final void praticar() {
        System.out.println("Tô estudando paizão.");
    }
    public final void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    @Override
    public void pagarMensalidade() {
        System.out.println("Mensalidade paga.");
    }

    @Override
    public String toString() {
        return "Tecnico{\n" +
                this.getNome() + "\n" + this.getIdade() + "\n" + this.getSexo() + "\n" + this.getMatricula() + "\n" + this.getCurso() + "\n" + "registroProfissional = '" + registroProfissional + '\'' +
                '}';
    }
}
