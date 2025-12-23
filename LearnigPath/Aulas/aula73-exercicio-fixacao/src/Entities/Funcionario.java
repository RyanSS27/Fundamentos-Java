package Entities;

public class Funcionario {
    private String nome;
    private double salario;
    private float imposto;

    public String aumento(float porcentagem) {
        this.salario = this.salario + (this.salario * porcentagem / 100);
        return """
                Aumento concluído. Salário atual: R$%f.
                """.formatted(this.salario);
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public void setSalario(double salario) {
        if (0 != imposto) {
            this.salario = salario - (salario* (this.imposto/100));
            //A ideia é que a entrada seja algo como XX%
        } else {
            System.out.println("Salário será incluído sem impostos.");
            this.salario  = salario;
        }
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public float getImposto() {
        return imposto;
    }

    @Override
    public String toString() {
        return """
                FICHA DO FUNCIONÁRIO
                Nome: %s
                Salário: R$%.2f
                Imposto: %.2f
                """.formatted(getNome(), getSalario(), getImposto());
    }
}
