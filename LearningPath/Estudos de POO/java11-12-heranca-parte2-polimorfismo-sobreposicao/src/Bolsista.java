public final class Bolsista extends Aluno {
    private float bolsa;

    public final void renovarBolsa() {
        System.out.println("Renovando a bolsa do cabâ.");
    }

    @Override
    public void pagarMensalidade() {
        System.out.println(this.getNome() + " é bolsista. Dá um jeitinho pra ele.");
    }

    @Override
    public String toString() {
        return "Bolsista{\n" +
                this.getNome() + "\n" + this.getIdade() + "\n" + this.getSexo() + "\n" + this.getMatricula() + "\n" + this.getCurso() +"\n}";
    }
}
